# memory model
在特定操作协议（firefly, dragon protocol, msi, mesi,mosi）下对特定内在或高速缓存进行读写访问过程的抽象.

## Java Memory Model

1 JMM规定了所有的变量都存储在主内存中
2 每条线程都有自己的工作内存
3 线程的工作内存中保存了被该线程使用到的变量的主内存中的副本拷贝，线程对变量的所有操作都必须在工作内在中进行，而不能直接读写主内在中的变量。

## JMM内存间交互操作
JMM定义了八种操作来完成主内存与工作内存之间的具体交互协议细节。每一种操作都是原子的不可再分的。
lock
unlock
read
load
use
assign
store
write

## volatile型变量
###保证可见性
	保证可见性的两条规则：
	运算指令中该变量不依赖变量的当前值
	变量不需要与其他状态变量共同参与不变约束

### 禁止指令重排序优化
JDK1.5才正式修复

我们一般认为volatile变量的读操作与普通变量无异，写操作要慢一些，因为它需要在本地代码中插入许多内存屏障来保证其不被乱序执行。
JVM对锁进行了许多消除和优化，我们很难量化的认为volatile比synchonized 快多少。

##hapens-before 原则
Program Order Rule: 程序次序规则
Monitor Variable Rule: 管程锁定规则
volatile variable rule: volatile变量规则
thread start rule: 线程启动规则
thread termination rule: 线程终止原则
thread interruption rule: 线程中断规则
finalizer rule: 对象终结规则
transitivity: 传递性

#Java线程调度

系统为线程分配处理器使用权的过程。
协同式和抢占式
Java为抢占式

# 线程安全
当多个线程同时访问一个对象时，如果不用考虑这些线程在运行时环境下的任何高度和交替执行，也不需要进行额外的同步，或者在调用方进行任何其他的协调操作，
调用这个对象的行为都可以获得正确的结果，那么这个对象是线程安全的。

## 五类线程安全（强度由高至低）
1. 不可变
2. 绝对线程安全
3. 相对线程安全
4. 线程兼容
5. 线程对立