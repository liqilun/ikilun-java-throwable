* Throwable
    * Error(#### Error类层次描述了Java运行时系统的内部错误和资源耗尽错误)
        * VirtualMachineError
            * OutOfMemoryError
          	* StackOverflowError
    * Exception
        * IOException
        * RuntimeException
        	* 错误的类型转换
			* 数组访问越界
			* 访问空指针

			
* spring AOP Transactional 事务回滚 分析
	* Exception
		* checked exception
		* unchecked exception
		如果客户端可以通过其他的方法恢复异常，那么这种异常就是checked exception；如果客户端对出现的这种异常无能为力，那么这种异常就是Unchecked exception；简单来说，继承于RuntimeException的都是unchecked exception
		在一个类的最外面加@Transactional

　　表示这个类的方法中，会开启事务

　　但这个事务只对unchecked( runtime exception)异常回滚

　　throw new RuntimeException("异常"); //这个回滚

　　throw new Exception("异常");//这个不回滚

　　对checked, Exception是不回滚的

　　如果要对checked异常进行回滚，则必须在此方法上加：

　　@Transactional(rollbackFor=Exception.class)

　　在mng(service)中，如果只是get值，那么可以在此方法上加：

　　@Transactional(propagation=Propagation.NOT_SUPPORTED)

　　事务默认为：

　　@Transactional(propagation=Propagation.REQUIRED)

　　REQUIRED：业务方法需要在一个事务中运行。如果方法运行时，已经处在一个事务中，那么加入到该事务，否则为自己创建一个新的事务