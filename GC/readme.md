##频繁GC
1. 人为原因： 代码中调用system.gc()或者Runtime.getRuntime.gc();
2. 框架原因： 第三方框中调用了GC方法
3. 内存原因： heap大小设置比较小时，会引起频繁GC
4. 其他原因：
	4.1： 构建与释放对象频繁
	4.2： 统计缓存命中率
	4.3： GC后保证heap 50%剩余空间，对server而言，要> 65%的剩余空间。

## Java内核专业博客
https://www.cubrid.org/blog/tags/Java/

## Java GC专业好文章
http://www.importnew.com/1993.html

stop-the-world会在GC任何一种算法中发生，stop-the-world意味着JVM要运行GC而停止一切与GC不相关的线程，使其进行等待状态直到GC完成。
GC优化就是批减少stop-the-world发生的时间。

## GC优化过程的记录文章

https://www.cnblogs.com/syjkfind/archive/2016/06/17/5595452.html

