package com.example.springbootfeignclient.utils;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class BigDecimalUtils extends StringUtils {

	public static BigDecimal moneyStrToBigDeciaml(String money) {
		return new BigDecimal(money.replace(",", ""));
	}

}
