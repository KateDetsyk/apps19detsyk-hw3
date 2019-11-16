package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    SmartArray smartArray;

    SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

}
