package rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/27
 **/
public class Consumer {
    /**
     * helloworld的开始demo
     */
    @Test
    public void consumer1() {
        Channel channel = null;
        try {
            // 1.发消息之前需要和rabbit mq的服务器建立连接
            channel = RabbitConnection.getConnection().createChannel();
            // 2.声明队列
            channel.queueDeclare("hello", false, false, false, null);
            // 3.消费者监听队列，并消费
            /**
             * 第一个参数：队列的名称
             * 第二个参数：是否自动确认接受到的消息
             * 第三个参数：一个实现Consumer接口的对象
             * */
            channel.basicConsume("hello", true, new DefaultConsumer(channel) {
                //4.处理接收到的信息，该方法会在consumer接受到消息之后回调
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println(new java.lang.String(body, "UTF-8"));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 可以将该方法执行三次，可以发现生产者发送的消息是均匀的被生产者接受（rabbit mq是使用轮询一个一个的使用消费者接受消息的）
     * 我们发现rabbit mq有以下三个特点：
     * 1.一条消息只会被一个消费者接收；
     * 2.消息是平均分配给消费者的；
     * 3.消费者只有在处理完某条消息后，才会收到下一条消息。
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @Test//work queue
    public void consumer2() throws IOException, InterruptedException {
        Channel channel = RabbitConnection.getConnection().createChannel();
        //第二个参数表示是否持久化队列
        channel.queueDeclare("hello", false, false, false, null);
        //第二个参数设置成false表示不需要自动确认，是否接受到消息
        channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "UTF-8"));
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Publish/Subscribe:
     * 对于消费者，我们需要为每一个消费者创建一个独立的队列，然后将队列绑定到刚才指定的交换机上即可：
     */
    @Test
    public void consumer3() throws IOException {
        Channel channel = RabbitConnection.getConnection().createChannel();
        //指定交换机以及交换机的名称
        channel.exchangeDeclare("notice", "fanout");
        // 该方法会创建一个名称随机的临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 将队列绑定到指定的交换机（"notice"）上
        channel.queueBind(queueName, "notice", "");
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "UTF-8"));
            }
        });
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
