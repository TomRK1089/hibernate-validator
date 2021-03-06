/*
* JBoss, Home of Professional Open Source
* Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.validator.internal.metadata.location;

import java.lang.annotation.ElementType;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

import org.hibernate.validator.internal.metadata.raw.ExecutableElement;

/**
 * A {@link ConstraintLocation} representing all the parameters of a method or
 * constructor; Used for cross-parameter constraints.
 *
 * @author Gunnar Morling
 */
public class CrossParameterConstraintLocation implements ConstraintLocation {

	private final ExecutableElement executableElement;

	public CrossParameterConstraintLocation(ExecutableElement executableElement) {
		this.executableElement = executableElement;
	}

	@Override
	public Class<?> getBeanClass() {
		return executableElement.getMember().getDeclaringClass();
	}

	@Override
	public Type typeOfAnnotatedElement() {
		return Object[].class;
	}

	@Override
	public ElementType getElementType() {
		return executableElement.getElementType();
	}

	@Override
	public Member getMember() {
		return executableElement.getMember();
	}
}
