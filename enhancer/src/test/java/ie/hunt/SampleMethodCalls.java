package ie.hunt;

@SuppressWarnings("unused")
public class SampleMethodCalls {

    public class Human {
        private final String name;
        private final int age;
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    public int getSomeValue(int in) {
        return 10;
    }

    public int getSomeValue(int in, int in2) {
        return 10;
    }

    public String getSomeValue(String in, String  in2) {
        return "dog";
    }

    public Human getSomeValue(String name, int age) {
        return new  Human(name,age);
    }

     public Human getSomeValue(String name, Integer age) {
        return new  Human(name,age);
    }






}
