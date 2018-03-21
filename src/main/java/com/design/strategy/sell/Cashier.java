package com.design.strategy.sell;

/**
 * 书籍价格计算类
 * 
 * @author cheng
 *
 */
public class Cashier {
	/**
	 * 会员,策略对象
	 */
	private Member member;

	public Cashier(Member member) {
		this.member = member;
	}

	/**
	 * 计算应付价格
	 * 
	 * @param booksPrice
	 * @return
	 */
	public double quote(double booksPrice) {
		return this.member.calPrice(booksPrice);
	}
}
