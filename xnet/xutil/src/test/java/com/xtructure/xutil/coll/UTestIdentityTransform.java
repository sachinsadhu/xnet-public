/*
 * Copyright 2012 Michael Roberts
 * All rights reserved.
 *
 *
 * This file is part of xutil.
 *
 * xutil is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation, either version 3 of the License, or (at your 
 * option) any later version.
 *
 * xutil is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License 
 * along with xutil.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.xtructure.xutil.coll;

import static com.xtructure.xutil.valid.ValidateUtils.assertThat;
import static com.xtructure.xutil.valid.ValidateUtils.isNotNull;
import static com.xtructure.xutil.valid.ValidateUtils.isSameAs;

import java.util.Collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xtructure.xutil.coll.IdentityTransform;
import com.xtructure.xutil.test.TestUtils;

/**
 * @author Luis Guimbarda
 * 
 */
@Test(groups = { "unit:xutil" })
public final class UTestIdentityTransform {
	private static final Object[][]	ARGS;
	static {
		ARGS = TestUtils.createData(//
				null,//
				1, 2.0, true, "asdf",//
				new int[] { 1, 2, 3 }, Collections.singleton(2.3));
	}

	@DataProvider
	public Object[][] args() {
		return ARGS;
	}

	public void constructorSucceeds() {
		assertThat("",//
				IdentityTransform.getInstance(), isNotNull());
	}

	@Test(dataProvider = "args")
	public void transformReturnsExpectedObject(Object o) {
		assertThat("",//
				IdentityTransform.getInstance().transform(o), isSameAs(o));
	}
}
