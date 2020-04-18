package com.company.ArrayList_EMS;

public class Worker {
        private Long id;
        private String name;

        public Worker(){}

        public Worker(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

}
