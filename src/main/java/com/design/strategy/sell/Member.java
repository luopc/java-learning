package com.design.strategy.sell;

/**
 * 会员接口
 * @author cheng
 *
 */
public interface Member {
	/**
	 * 计算价格
	 * 传入书籍的价格，根据会员等级的不同，计算不同的价格
	 * @return
	 */
	double calPrice(double bookPrice);

}
