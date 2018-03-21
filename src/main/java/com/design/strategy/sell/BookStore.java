package com.design.strategy.sell;

/**
 * 使用策略模式来实现不同的折扣
 * 
 * @author cheng
 *
 */
public class BookStore {

	public static void main(String[] args) {
		Member me = new IntermediateMember();//定义不同的会员
		Cashier cs = new Cashier(me);//根据会员使用策略
		double price = cs.quote(56.25);//计算价格
		System.out.println("购买价格为：" + price);
	}
}

/**
 * 初级会员
 * @author cheng
 *
 */
class PrimaryMember implements Member {

	@Override
	public double calPrice(double bookPrice) {
		System.out.println("对于初级会员的没有折扣");
		return bookPrice;
	}
}

/**
 * 中级会员
 * @author cheng
 *
 */
class IntermediateMember implements Member {

	@Override
	public double calPrice(double bookPrice) {
		System.out.println("对于中级会员的折扣为10%");
		return bookPrice * 0.9;
	}
}

/**
 * 高级会员
 * @author cheng
 *
 */
class AdvancedMember implements Member {

	@Override
	public double calPrice(double bookPrice) {
		System.out.println("对于中级会员的折扣为20%");
		return bookPrice * 0.8;
	}
}