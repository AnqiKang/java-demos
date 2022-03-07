package codeTest.designPattern.builder;

import codeTest.designPattern.builder.Computer;
import codeTest.designPattern.builder.ComputerBuilder;

public class HighComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();

    @Override
    public void builderCpu() {
        computer.setCpu("high level cpu");

    }

    @Override
    public void builderMainboard() {
        computer.setMainboard("high lever main board");

    }

    @Override
    public void builderDisk() {
        computer.setDisk("high level disk");

    }

    @Override
    public void builderPower() {
        computer.setPower("high level power");

    }

    @Override
    public void builderMemory() {
        computer.setMemory("high level memory");

    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
