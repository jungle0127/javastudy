package org.multithreads.synchonizedkeyword.sobj;

/*
 * 指定要给某个对象加锁
 * 
 * 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：
 * class Test implements Runnable
{
   private byte[] lock = new byte[0];  // 特殊的instance变量
   public void method()
   {
      synchronized(lock) {
         // todo 同步代码块
      }
   }

   public void run() {

   }
}
 */
public class AccountOperator implements Runnable {
	private Account account;
	public AccountOperator(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		synchronized(this.account){
			for(int i = 0; i < 100; i++){
				this.account.deposit(500.0f);
				this.account.withdraw(500.0f);
			}
			System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
		}

	}

	public static void main(String[] args) {
		Account account = new Account("jinghe", 100000.0f);
		AccountOperator ao = new AccountOperator(account);
		Thread threads[] = new Thread[5];
		for(int i = 0; i< 5; i++){
			threads[i] = new Thread(ao,"Thread" + i);
			threads[i].start();
		}
	}

}
