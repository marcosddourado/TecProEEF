# Stylesheet

## Summary
##   [1. Source Files](#1-source-files-1)
#### [1.1 ](#11-in-general-every-cpp-file-should-have-an-associated-hpp-file)
#### [1.2 ](#12-define-guards-1)
#### [1.3 ](#13-forward-declarations-1)
#### [1.4 ](#14-inline-functions-1)
___
##   [2. Source File and structure](#2-scoping-1)
#### [2.1 ](#21-namespaces-1)
#### [2.2 ](#22-local-variables-1)
#### [2.3 ](#23-static-and-global-variables-1)
___
##   [3. Programming Practices](#3-classes-1)
#### [3.1 ](#31-constructors-1)
#### [3.  ](#32-structs-vs-classes-1)
#### [3.3 ](#33-inheritance-1)
#### [3.4 ](#34-virtual-classes-1)
#### [3.5 ](#35-operator-overloading-1)
#### [3.6 ](#36-access-control-1)
#### [3.7 ](#37-declaration-order-1)
___
##   [4. Naming](#4-functions-1)
#### [4.1](#41-parameters-order-1)
#### [4.2](#42-return-type-1)
___
##   [5. Javadoc](#5-other-features-1)
#### [5.1 ](#51-other-features-1)
#### [5.2 ](#52-casting-1)
#### [5.3 ](#43-preincrement-and-postincrement-1)
#### [5.4 ](#54-constconstexpr-1)
#### [5.5 ](#55-macros-1)
#### [5.6 ](#56-zeros-1)
#### [5.7 ](#57-sizeof-1)
___
##   [6. Formatting](#6-naming-1)
#### [6.1 ](#61-variables-functions-1)
#### [6.2 ](#62-class-members-1)
#### [6.3 ](#63-classes-structs-enums-1)
#### [6.4 ](#64-namespaces-1)
#### [6.5 ](#65-macros-1)
___
##   [7. Comments](#7-comments-1)
___

## 1. Source Files

#### 1.1 File Name
The source file name consists of the case-sensitive name of the top-level class it contains, plus the `.java` extension.


#### 1.2 Structure
  * Header, containing the file name. It may contain the file purpose if needed.
  * Package statement.
  * Import statements.
  * One top-level class/interface.
<!-- Exemplo -->

#### 1.3 Import Statements

##### 1.3.1 Wildcard Imports
`import com.mdsgpp.eef.model.*`
Wildcard imports should not be used.

##### 1.3.2 Line Wrapping
Import statements should never be line-wrapped. The column limit does not apply to import statements.
<!-- Exemplo -->

#### 1.4 Class Declaration

##### 1.4.1 Only one top-level class declaration
Each top-level class resides in its own source file.
<!-- Exemplo -->

##### 1.4.2 Class Member Order
  * `private` attributes and methods.
  * `protected` attributes and methods.
  * `public` attributes and methods.
<!-- Exemplo -->

## 2. Programming Practices

#### 2.1 `@Override`
`@Override` must be used whenever it is legal. It must be placed on the line before the overridden method.
<!-- Exemplo -->

#### 2.2 Caught Exceptions
Caught exceptions should never be ignored. The runtime error should be treated into the appropriate scope.
<!-- Exemplo -->

#### 2.3 Static Members
Whenever a reference to a static member have to be called, it should be called directly from the class.
<!-- Exemplo -->

## 4. Naming
<!-- Exemplos -->

#### 4.1 Classes
UpperCamelCase

#### 4.2 Methods
lowerCamelCase()

#### 4.3 Class Members
lowerCamelCase

#### 4.4 Constants
SCREAMING_SNAKE_CASE

#### 4.5 Local Variables
lowerCamelCase

#### 4.6 Parameters
lowerCamelCase

## 5. Javadoc

#### 5.1

#### 5.2

#### 5.3

#### 5.4

#### 5.5

#### 5.6

#### 5.7

## 6. Formatting

#### 6.1

#### 6.2

#### 6.4

## 7. Comments
