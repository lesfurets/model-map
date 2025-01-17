/*
 * Copyright 2017 Courtanet
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.doov.core.dsl.meta.ast;

import static io.doov.core.dsl.meta.i18n.ResourceBundleProvider.BUNDLE;

import java.util.Locale;

import io.doov.core.dsl.meta.SyntaxTree;

public class AstVisitorUtils {

    public static String astToString(SyntaxTree syntaxTree, Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        syntaxTree.accept(new AstLineVisitor(stringBuilder, BUNDLE, locale), 0);
        return stringBuilder.toString();
    }

    public static String astToMarkdown(SyntaxTree syntaxTree, Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        syntaxTree.accept(new AstMarkdownVisitor(stringBuilder, BUNDLE, locale), 0);
        return stringBuilder.toString();
    }

}
