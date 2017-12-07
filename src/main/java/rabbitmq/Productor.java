package rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/27
 **/
public class Productor {
    @Test
    public void produce1() {
        try {
            // 1.发消息之前需要和rabbit mq的服务器建立连接
            Channel channel = RabbitConnection.getConnection().createChannel();
            // 2.建立一个名为hello的队列
            channel.queueDeclare("hello", false, false, false, null);
            // 3.向队列hello中发送Hello Test消息（这里的hello是路由键，与队列名相同）
            channel.basicPublish("", "hello", null, "Hello Test".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void produce2() throws TimeoutException {
        try {
            Channel channel = RabbitConnection.getConnection().createChannel();
            channel.queueDeclare("hello", false, false, false, null);
            for (int i = 0; i < 10; i++) {
                channel.basicPublish("", "hello", null, String.valueOf(i).getBytes());
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Publish/Subscribe:一条消息能够被多个消费者接受到
     *
     * 事实上，生产者是把消息发送到了交换机（exchange）中，然后交换机负责（决定）将消息发送到（哪一个）消息队列中。
     * 每一个被创建的队列都会被自动的绑定到默认交换机上，并且路由键就是队列的名字。
     * 除此之外，交换机还有4种：direct，fanout，topic，headers
     * 1.direct:direct类型的交换机要求和它绑定的队列带有一个路由键K，若有一个带有路由键K的消息到达了交换机，交换机会将此消息路由到路由键为K的队列，默认交换机便是该类型。
     * 2.fanout:fanout类型的交换机会路由每一条消息到所有和它绑定的队列，忽略路由键。
     */
    @Test
    public void produce3() throws IOException {
        Channel channel=RabbitConnection.getConnection().createChannel();
        //第一个参数：交换机的名称，第二个参数：交换机的类型。
        channel.exchangeDeclare("notice","fanout");
        //第一个字段就是指定交换机的名字
        //第二个字段就是路由键,而空字符串则表示默认的交换机，
        //如果交换机为空字符串，则表示使用默认交换机。其好处就是每一个被创建的队列都会被自动的绑定到默认交换机上，并且路由键就是队列的名字。
        channel.basicPublish( "notice", "", null, "hahahahaha".getBytes());
    }


    @Test
    public void produce4() throws IOException{
        Channel channel=RabbitConnection.getConnection().createChannel();
        final String corrId = UUID.randomUUID().toString();
        String replyQueueName = channel.queueDeclare().getQueue();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)//可以用于在客户端之间标记或者标识消息的client-specific标识
                .replyTo(replyQueueName)//通常用于命名应答队列
                .build();
        channel.basicPublish("cancel_exchange_name", "", props, "hahahahaahahhah".getBytes("UTF-8"));
        //使用一个阻塞队列
        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);
        //消费者
        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    //向阻塞队列中添加消息
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

    }

}
