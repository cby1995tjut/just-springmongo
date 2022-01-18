##并发

### 1.Volatile 关键字的作用

1 防止指令重排  
2 保证可见性
解释:TBD

### 2.并发安全问题是指?
Q: TBD

### 3. synchronize 关键字
#### 原语实现:
Q: TBD
#### 锁静态方法和所普通方法的区别
Q: TBD
#### 是否可重入? 锁Q: TBD粗化/锁消除

### 4.ReentrantLock 源码实现
`    构造方法: 默认为非公平锁

    public ReentrantLock() {
        sync = new NonfairSync();
    }`

通过lock方法对代码进行加锁,

加锁的实现原理: 尝试获取锁，如果是当前线程第一次获取  
1.那么就会调用setExclusiveOwnerThread，将里面的变量exclusiveOwnerThread设置成为当前线程  
2.反之就会调用acquire(1)方法,也是先尝试获取锁，如果成功，则调用1中的步骤,如果失败,则会将当前线程和etExclusiveOwnerThread
做对比，如果是当前线程是持有锁的线程，则将lock内的变量state + 1,  
如果不是，则调用Thread的interrupt方法，打断当前线程  
**部分源码已经粘贴到ReentrantLockTester中**