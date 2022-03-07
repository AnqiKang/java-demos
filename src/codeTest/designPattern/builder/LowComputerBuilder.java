package codeTest.designPattern.builder;

/**
 * 具体的建造者，实现Builder来创建不同的产品
 * 低配版电脑
 */
public class LowComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void builderCpu() {
        computer.setCpu("lower level cpu");

    }

    @Override
    public void builderMainboard() {
        computer.setMainboard("low lever main board");

    }

    @Override
    public void builderDisk() {
        computer.setDisk("low level disk");

    }

    @Override
    public void builderPower() {
        computer.setPower("low level power");

    }

    @Override
    public void builderMemory() {
        computer.setMemory("low level memory");

    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
