package com.chedl.service.user.serviceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserProvider {
	private static final Log log = LogFactory.getLog(UserProvider.class);
	public static void main(String[] args) throws Exception {
		try {
			//读取Spring配置文件applicationContext.xml，并启动
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
			context.start();
			log.info("服务已经启动...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//对该类加同步锁，服务启动后进行线程等待，保证服务一直运行着 
		synchronized (UserProvider.class) {
			while (true) {
				try {
					//当前线程放弃同步资源锁，进入等待队列
					UserProvider.class.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					log.error("synchronized error");
				}
			}
		}
	}
}