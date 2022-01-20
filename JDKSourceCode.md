##并发

### 1.Volatile 关键字的作用

1 防止指令重排  
2 保证可见性  
解释: 每个线程都有属于自己的缓冲区，当缓冲区的数据发生变更时，会定时或者不定时的同步到主存，而不是立马同步到主存，这样就会导致其他线程看到的数据不是最新的
而当给变量加上volatile关键字后，变量发生变更时，会强制将数据刷新到主存，并且其他线程在获取该volatile字段时，也会强制访问主存中的数据，  
这样就保证了数据的可见性



### 2.并发安全问题是指?
Q: TBD

### 3. synchronize 关键字
#### 原语实现:
monitorIn & monitorExit

#### 锁静态方法和锁普通方法的区别
锁静态方法: 锁的是class对象  
锁普通方法: 锁的是class实例化出来的对象  

#### 是否可重入? 重入锁的实现原理? 
可重入，如果是当前线程，则对记录锁状态state + 1,退出则减一

#### 锁Q: TBD粗化/锁消除

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