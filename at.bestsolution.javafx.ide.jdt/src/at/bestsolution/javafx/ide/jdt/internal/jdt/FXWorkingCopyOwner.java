/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.javafx.ide.jdt.internal.jdt;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.WorkingCopyOwner;

public class FXWorkingCopyOwner extends WorkingCopyOwner {
	private final IProblemRequestor problemRequestor;
	
	public FXWorkingCopyOwner(IProblemRequestor problemRequestor) {
		this.problemRequestor = problemRequestor;
	}
	
	@Override
		public IProblemRequestor getProblemRequestor(ICompilationUnit workingCopy) {
			return problemRequestor;
		}
}
