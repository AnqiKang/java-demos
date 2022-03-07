package codeTest.designPattern.builder;

public class ComputerTest {
    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        Computer lowComputer = computerDirector.create(new LowComputerBuilder());
        Computer highComputer = computerDirector.create(new HighComputerBuilder());

        System.out.println(lowComputer);
        System.out.println(highComputer);
    }
}
