package json.gson;

import lombok.Getter;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/26
 **/

public class StudentVO {
    @Getter
    private String no;
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private String tel;

    private StudentVO(Builder builder) {
        this.no = builder.no;
        this.name = builder.name;
        this.age = builder.age;
        this.tel = builder.tel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String no;
        private String name;
        private int age;
        private String tel;

        public Builder setNo(String no) {
            this.no = no;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public StudentVO build() {
            return new StudentVO(this);
        }
    }
}
