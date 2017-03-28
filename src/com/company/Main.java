package com.company;

import com.pattern.adaptor.*;
import com.pattern.builder.*;
import com.pattern.decorator.Decorator;
import com.pattern.decorator.OriginalObject;
import com.pattern.facade.Facade;
import com.pattern.factory.AddOperationFactory;
import com.pattern.factory.IOperation;
import com.pattern.factory.IOperationFactory;
import com.pattern.factory.SubtractOperationFactory;
import com.pattern.proxy.Beauty;
import com.pattern.proxy.Proxy;
import com.pattern.proxy.Pursuiter;
import com.pattern.state.OrderInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static String strClassName = Main.class.getName();
    public static Logger mLogger = Logger.getLogger(strClassName);

    public static void main(String[] args) {
	// write your code here
//        SortSolution sortSolution = new SortSolution();

//        int a[] = {8, 2, 5, 3, 9, 6};
//        sortSolution.bubbleSort(a);
//        sortSolution.selectSort(a);
//        sortSolution.insertSort(a);
//        int[] result = new int[a.length];
//        sortSolution.mergeSort(a, 0, a.length-1, result);
//        sortSolution.quickSort(a, 0, a.length-1);
        //        logger.info("" + result);
//        listNodeDemo();
//        factoryPattern();
//        decoratorPattern();
//        adapterPattern();
//        facadePattern();
//        proxyPattern();
//        builderPattern();
        statePattern();
    }


    private static void listNodeDemo() {
        ListNodeSolution solution = new ListNodeSolution();
        int a[] = {8, 2, 5, 3, 9, 6};
        ListNode head = solution.createListNode(a);
//        ListNode reversedHead = solution.reverseListNode(head);
//        ListNode result = solution.getListNode(head, 4);
//        ListNode result = solution.getMiddleListNode(head);
        List<Integer> resultArray = new ArrayList<Integer>();
        solution.printReverseListNode(head, resultArray);
    }

    private static void factoryPattern() {
        IOperationFactory factory1 = new AddOperationFactory();
        IOperation operation1 = factory1.createOperation();
        operation1.doSomething();

        IOperationFactory factory2 = new SubtractOperationFactory();
        IOperation operation2 = factory2.createOperation();
        operation2.doSomething();
    }

    private static void decoratorPattern() {
        // 在不改变OriginalObject代码的基础上，为其增加方法和处理逻辑，如输出中的“doSomethingElse”方法
        OriginalObject object = new OriginalObject();
        Decorator decorator = new Decorator(object);
        decorator.doSomething();
    }

    private static void adapterPattern() {
        // 注意与装饰模式的区别，装饰模式是在对象原有功能的基础上，增加新功能。
        // 适配器模式是新对象与旧对象功能不一样，adapter类持有新对象，在实现旧对象接口方法中去调用新对象的方法，即将调用翻译一下，从外在看，能保证接口方法的统一
        IPlayer player = new Guard();
        player.attack();
        player.defend();

        player = new Center();
        player.attack();
        player.defend();

        player = new Adapter(new ForeignPlayer());
        player.attack();
        player.defend();
    }

    private static void facadePattern() {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }

    private static void proxyPattern() {
        Beauty mm = new Beauty("冰冰");
        Pursuiter pursuiter = new Pursuiter("李晨");
        Proxy proxy = new Proxy(pursuiter);
        proxy.giveFlowers();
        proxy.giveDolls();
    }

    private static void builderPattern() {
        Director director = new Director();
        IBuilder builderA = new BuilderA();
        Product productA = director.createProduct(builderA);
        productA.showParts();

        IBuilder builderB = new BuilderB();
        Product productB = director.createProduct(builderB);
        productB.showParts();
    }

    private static void statePattern() {
        OrderInfo order = new OrderInfo();
        order.updateUI();
        order.state = OrderInfo.kDispatching;
        order.updateUI();
        order.state = OrderInfo.kAccept;
        order.updateUI();
        order.state = OrderInfo.kDriving;
        order.updateUI();
        order.state = OrderInfo.kStandby;
        order.updateUI();
    }

}
