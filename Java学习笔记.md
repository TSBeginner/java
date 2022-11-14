## Java学习步骤

###  阶段1：Java 编程基础

#### 1.1 什么是程序

计算机为**执行操作**或**解决问题**而编写的一系列有序**指令集合**。

#### 1.2 Java 特点（看不懂没事，别背！）

  1.面向对象(oop）

  2.健壮的，强类型机制、异常处理、垃圾自动收集

  3.跨平台[一个编译好的.class文件（字节码文件）可以在多个系统下运行]

  4.解释型语言(java/python/js)对应编译型语言（c/c++）

#### 1.3 环境搭建（JVM java虚拟机）

**JVM+java核心类库=JRE（java运行环境），JRE+java开发工具【java/javac/javadoc等】=JDK（java开发工具包）**

![image-20220917153557603](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220917153557603.png)

![image-20220917154006830](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220917154006830.png)

#### 1.4 java快速入门

​	第一个代码：

```java
public class hello{
    public static void main(String[] args){
        System.out.println("hello,java");
    }
}
```

​	**注意事项**

​	1.Java源文件以.java为扩展名。源文件进行编译得到.class字节码文件，源文件的基本组成部分是类（class）。

​	2.Java应用程序的执行入口是main()方法。它是固有的书写格式：

```java
public static void main(String[] args){...}
```

​	3.Java语言严格区分大小写。

​	4.Java方法由一条条语句构成，每个语句以‘’;“（分号）结束。

​	5.大括号都是成对出现的，缺一不可。【习惯，先写{}再写代码】

​	6.一个源文件中最多只能有一个public类。其他的类个数无限。

​	7.如果源文件中包含一个public类，则文件名必须按该类名命名。

​	8.可以将main()方法写在非public类中，然后指定运行非public类，这样入口方法就是非public的main方法了。

```java
public class a{
	public void b(){
			System.out.println("这是公共类里的非主方法");
	}

}
class c{
	public static void main(String[] args){
		System.out.println("这是非公共类里的主方法");
	}
}

//cmd  利用 javac a.java 进行编译 java c 运行c类

```

  ![image-20220920145824833](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920145824833.png)

![image-20220920145926427](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920145926427.png)



  9.注意java程序编写的字符都应该为英文。



#### 1.5 Java 基础语法

##### 1.5.1 java转义字符

1. \n ：换行符

2. \t :一个制表位（tab）实现对齐的功能

3. \\" :表示一个 "

4. \\' :表示一个 ’

5. \r :一个回车键  

6. \\\ :表示一个\

   注意：\r 只有回车没有换行例如以下代码：

   ```java
   System.out.println("老唐学java\r湖南");
   //最后输出结果为：湖南学Java
   //遇到/r时光标会移到最前面然后继续输出后面的内容。
   ```

##### 1.5.2注释

- 介绍

用于注解说明解释程序的文字，可提高代码的阅读性（可读性）

- 类型

​    1.单行注释

​	//

​	2.多行注释:不允许嵌套使用

​	/*   */

​	3.文档注释

​	 /**    */

### 2. 变量与数据类型

#### 	2.1 变量

- 变量是程序的基本组成单位

- 基本要素

  类型+变量名+变量值

- 概念

  变量相当于内存中一个数据存储空间的表示，而通过变量名可以访问到变量值。

- ＋号的使用

  1. 当左右两边都为数值型时，做加法运算

  2. 当左右两边有一方为字符串，着做拼接运算。（连接符）

  3. 运算顺序从左到右

     如以下代码：

     ```java
     System.out.println(100+2);  //102
     System.out.println("100"+23);  //10023
     System.out.println("hello"+100+2);  //hello1002
     System.out.println(100+2+"hello");  //102hello
     ```

     

#### 	2.2数据类型

##### 		2.2.1基本数据类型

###### 			1.数值型

​				整数类型：byte[1]，short[2]，int[4]，long[8]

​				浮点类型：float[4]，double[8]

###### 			2.字符型

​				char[2]：存放单个字符 ’a‘

###### 			3.布尔型

​				boolean[1：存放” true “或” false “

######  			4. **字符编码：**

​			**ASCLL**（ASCLL编码表，一个字节表示，一共128个字符，实际上一个字节可以表示256个字符，但用不完）

​			**Unicode**（固定大小的编码，使用两个字节来表示字符，字母和汉字都占2个字节）

​			**utf-8**（大小可变，字母1个字节，汉字3个字节）

​			**gbk**（可表示汉字，而且范围广，字母1个字节，汉字2个字节）

​			**gb2312**（可表示汉字，gb2312<gbk）

​			**big5**(繁体中文)

##### 		2.2.2基本数据类型的转换		

###### 			1.自动转换

​				概述：当Java程序在进行赋值或运算时，精度小的类型自动转换为精度（容量）大的数据类型。

​				数据类型按**精度**（容量）大小排序：（小——>大）

​				char——>int——>long——>float——>double

​				byte——>short——>int——>long——>float——>double

​				**自动转换的细节**

​					1、有多种类型的数据**混合运算**时，系统会首先将所有数据转换成**精度最大**的那种数据类型，然后进行计算。

​					2、（byte/short）与char之间不会互相自动转换。

​					3、byte，short，char他们三者可以计算，在计算时首先**转换为int**类型

​					4、boolean不参与转换。

​					5、自动提升原则：表达式结果的类型自动提升为操作数中最大的类型。

###### 			2.强制转换

​				概述：自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转换符( ),但可能造成精度降低或溢出。

​				**细节**

​				1、当进行数据大小从 大——>小，就需要使用到强制转换。

​				2、	强制转换只针对于最近的操作数有效，往往会使用小括号提升优先级

```java
int x = (int)10*3.5+6*1.5; //int只对10有用所有结果为double——>int,编译出错
int y =(int)(10*3.5+6*1.5);//int(44.0)——>int,44
```

​				3、char类型可以保存int的常量值，但不能保存int的变量值，需要强制转换

```java
char c1 = 100; //ok
int m = 100;  //ok
char c2 = m;  //错误
char c3 = (char)m; //ok
System.out.println(c3); //输出100对应的字符d
```

​				4、byte和short类型在进行运算时，当做int类型处理。

###### 			3. 基本数据类型转换练习

​	判断是否能够通过编译：		

```java
short s = 12;  //ok
s = s-9;    //错误，9为int类型所以结果为int不能直接赋值给short类型
byte b = 10; //ok
b = b+11;  //错误，11为int类型所以结果为int不能直接赋值给byte类型
b = (byte)(b+11);  //ok
char c1 = 'a';  //ok
int i = 16;   //ok
float d = .314F;  //ok
double result = c1+i+d;    //ok  float——>double
byte b1 = 16;  //ok
short s1 =14;  //ok
short t = s1+b1 //错误，byte与short之间运算后的结果为int不能直接赋值给short类型
```

##### 		2.2.3.基本数据类型与字符串String之间的互相转换

​			基本数据类型转换成String

​			语法：将基本类型的值+” “即可

![image-20220918192549007](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220918192549007.png)

​			String转换成基本数据类型

​				语法：通过基本类型的包装类调用parseXX方法即可

![image-20220918193251453](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220918193251453.png)

​			**注意**：String——>char时 String提供char charAt (int index)方法返回指定索引处的 char值。

#####     	2.2.4引用数据类型

###### 			1.类（class）                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

###### 			2.接口（interface）

###### 			3.数组（[ ]）

### 3. 运算符

#### 	3.1  运算符的介绍

​			**介绍**

​			    运算符是一种特殊的符号，用于表示数据的运算、赋值和比较

​			**分类**

​				1.算术运算符

​				2.赋值运算符

​				3.关系运算符（比较运算符）

​				4.逻辑运算符

​				5.位运算符（二进制）

​				6.三元运算符

#### 	3.2  算术运算符

![image-20220918201024720](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220918201024720.png)

#### 3.3关系运算符

![image-20220919175404570](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220919175404570.png)

#### 3.4逻辑运算符

- 介绍

  用于连接多个条件（关系表达式），最终的结果也是一个boolean值。

- 分类

  1）短路与 && ，短路或 ||，取反 ！

  2）逻辑与 & ，逻辑或 | ，逻辑异或  ^

- 规则

  1）a&b:"&"逻辑与，当a和b同时为true，则结果为true，否则结果为false。

  2）a&&b:"&&"短路与，与逻辑与一样。

  3）a|b："|"叫逻辑或，当a和b，有一个为true，则结果为true，否则为false。

  4）a||b:"||"短路或，同逻辑或。

  5)!a: "!"取反或者非运算，当a为true则结果为false。

  6)a^b:"^"逻辑异或，当a和b**不同**时结果为true，则结果为false。

- 逻辑与“&”和短路与“&&”的区别

  **对于&&短路与而言，如果第一个条件为false，后面的条件语句不再执行和判断；而对于&逻辑与而言，如果第一个条件为false，后面的条件仍然会判断。**

  ```java
  int a = 4;
  int b = 9;
  if(a < 1 & ++b < 50){   //逻辑与
  	System.out.println("ok");
  }
  System.out.println("a="+a+"b="+b);  //4 10
  if(a < 1 && ++b < 50){   //短路与
  	System.out.println("ok");
  }
  System.out.println("a="+a+"b="+b);  //4 9
  ```

- 短路或"||"和逻辑或"|"

  **短路或：如果第一个条件为true,则第二个条件不会判断**

  **逻辑或：不管第一个条件的结果如何，第二个条件都要判断**

#### 3.5 赋值运算符

- 介绍

  赋值运算符就是·将某个运算后的值，赋值给指定的变量。

- 分类

  1）基本赋值运算符：  “ = ”

  2）复合赋值运算符： +=，-=，*=，/=，%=

- 赋值运算符特点

  1）运算顺序从右往左  int num = a + b +c;。

  2）赋值运算符的左边只能是变量，右边可以是变量、表达式、常量值。

  3）复合赋值运算等价于下面效果

  ​    比如：a += 3 等价于a = a + 3;其他一样。

  **4）复合赋值运算符会进行类型转换。**

  ```java
  byte b = 2; 
  b += 3; //等价于 b = (byte)(b + 2)  强制转换
  b = b + 3;  //编译错误
  b++;  // b = (byte)(b + 1)
  b = b + 1; //编译错误
  ```

   

#### 3.6 三元运算符

- 基本语法

  条件表达式？表达式1：表达式2；

- 运算规则

  1）如果条件表达式为true，运算后的结果是表达式1；

  2）如果条件表达式为false，运算后的结果是表达式2；

- 代码演示

  ```java
  int a = 10;
  int b = 9;
  int result = a > b? a++ : b--; // 10
  ```

  

#### 3.7 运算符的优先级

![image-20220919202607547](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220919202607547.png)

​          **上行优先于下行**

​    	1）() , {}

​		2）单目运算：++ --

​		3）算术运算符： * / % + -

​		4）位运算符：>> << >>>

​		5)比较运算符

​		6)逻辑运算符

​		7)三元运算符

​		8)赋值运算符

#### 3.8 标识符

###### 	3.8.1标识符概念

​	java对各种变量、方法、类等的命名时使用的字符序列称为标识符

###### 	3.8.2标识符命名规则

1. 由26个英文字母大小写，0-9，_ 或 $ 组成。
2. 数字不能用于开头。
3. 不可以使用关键字和保留字，但可以包含关键字和保留字（goto）。
4. java中严格区分大小写，长度无限制。
5. 标识符不包括空格。

###### 	3.8.3标识符命名规范

1. 包名：多单词组成时所有单词都小写：aaa.bbb.ccc//比如：com.ts.job
2. 类名、接口名：多单词组成时，第一个单词首字母大写：XxxYyyZzz【大驼峰】比如：TankShortGame
3. 变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz【小驼峰】 比如tankShortGame
4. 常量名：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY

###### 	3.8.4 java中的关键字与保留字

1. 关键字：都是小写字母

   <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920161656795.png" style="zoom:80%;" />

2. 保留字

   - 介绍

     现有java版本尚未使用，但以后版本可能会作为关键字使用。

   - 比如以下

     byValue、cast、future、generic、inner、operator、outer、rest、var、goto、const 等

   

### 4  java程序控制结构

#### 	4.1 输入语句

- 介绍

  在编程中，需要收用户输入的数据，就可以使用键盘输入语句来获取。

  需要一个扫描器，就是Scanner

- Scanner对象介绍

  位于 java.util.Scanner 包中所以时需要导入（import）此包.

  **构造器：**

  1. Scanner(Readable source) ：造一个新的 `Scanner` ，它生成从指定源扫描的值。 

     比如 System.in

  

  **常用方法：**

  1. void close（） ：关闭此扫描仪
  2. String next( ) ：查找并返回此扫描程序中的下一个完整令牌，遇到空格结束。
  3. String nextLine( )：使此扫描器前进超过当前行并返回跳过的输入。 
  4. int nextInt( ) ：将输入的下一个标记扫描为 `int` 。


#### 4.2 顺序控制

- 介绍

  程序从上到下逐行的执行，中间没有任何判断和跳转。

- 流程图及注意事项

  1. 流程图：

     ![image-20220920180959243](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920180959243.png)

  2. 注意事项：

     java中定义变量时采用合法的向前引用。如：

     //正确示范

     int a = 2; int b = a + 6;

     //错误示范

     int a = b + 5; int b =9;

#### 4.3 分支控制（if...else、switch）

- if...else介绍

  让程序有选择的执行，分支控制分为以下三种

  1. 单分支
  2. 双分支
  3. 多分支


- 单分支：

  1. 基本语法：

     if(条件表达式){

     ​	执行代码块；

     }

     说明：当条件表达式为ture时，就会执行{}中的代码。如果为false，就不执行{}里的。如果{}中只有一条语句，则可以省略{}。建议不要省

  2. 案例说明

     ```java
     //if单分支
     /**
      * 编写一个程序，可以输入人的年龄，
      * 如果该同志年龄大于18岁
      * 则输出"你的年龄大于等于18，要对自己的行为负责"
      */
     import java.util.Scanner;
     public class If01{
     	public static void main(String[] args){
     		Scanner in = new Scanner(System.in);
     		System.out.println("请输入你的年龄：");
     		int age = in.nextInt();
     		if(age >= 18){
     			System.out.println("你的年龄大于等于18，要对自己的行为负责");
     		}
     	}
     }
     
     ```

  3. 单分支流程图

     ![image-20220920193022789](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920193022789.png)

- 双分支

  1. 基本语法

     if(条件语句){

     执行代码块1；

     }

     else{

     执行代码块2；

     }

     **说明：**当条件表达式成立，即执行代码块1，否则执行代码块2。

  2. 案例演示

     ```java
     /**
      * 编写一个程序,可以输入人的年龄,如果该同志的年龄大于18岁,
      * 则输出"你年龄大于18,要对自己的行为负责,送入监狱"。
      * 否则,输出"你的年龄不大这次放过你了."
      */
     import java.util.Scanner;
     public class If02{
     	public static void main(String[] args){
     		Scanner in = new Scanner(System.in);
     		System.out.println("报上你的年龄：");
     		int age = in.nextInt();
     		if(age >= 18){
     			System.out.println("你的年龄大于等于18，要对自己的行为负责,送入监狱.");
     		}
     		else{
     			System.out.println("你的年龄不大这次放过你了.");
     		}
     	}
     }
     ```

     

  3. 双分支流程图

     ![image-20220920195029118](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920195029118.png)

- 多分支

  1. 基本语法

     if(条件表达式1){

     执行代码块1；

     }

     else if(条件表达式2){

     执行代码块2；

     }

     ......

     else{

     执行代码块n；

     }

  2. 流程图

     ![image-20220920195501152](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920195501152.png)

  3. 案例演示

     ```java
     /**
      * 输入保国同志的芝麻信用分:如果:
      *1．信用分为100分时,输出信用极好;
      *2.信用分为(80,99]时,输出信用优秀;
      *3.信用分为[60,80]时，输出信用一般;
      *4.其它情况，输出信用不及格.
      *5.请从键盘输入保国的芝麻信用分,并加以判断
      */
     import java.util.Scanner;
     public class If03{
     	public static void main(String[] args){
     		Scanner in = new Scanner(System.in);
     		System.out.println("报上你的芝麻信用分(0-100)：");
     		int score = in.nextInt();
     		if(score == 100){
     			System.out.println("信用极好!");
     		}
     		else if(score > 80 && score < 100){
     			System.out.println("信用优秀!");
     		}
     		else if(score >= 60 && score < 80){
     			System.out.println("信用优秀!");
     		}
     		else{
     			System.out.println("信用不及格!");
     		}
     	}
     }
     ```

     

- 嵌套分支

  1. 基本介绍

     在一个分支结构中又完整的嵌套了另一个完整的分支结构，里面的分支的结构称为内层分支外面的分支结构称为外层分支。**建议**:不要超过3层(可读性不好)

  2. 基本语法

     if(){

     ​	if(){

     ​		//if-else...

     ​	}

     ​	else{

     ​	}

     }

     else{

     }

  3. 应用案例

     参加歌手比赛，如果初赛成绩大于8.0进入决赛，否则提示淘汰。并且根据性别提示进入男子组或女子组。输入成绩和性别，进行判断和输出信息。

  

- switch分支结构

  1. 基本语法

     ![image-20220920202152243](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220920202152243.png)

     **说明：**

     1）表达式：对应一个值

     2）case 常量1：当表达式的值等于这个常量时，就执行语句块1

     3）break：表示退出switch

     4）如果表达式的值与case 常量1匹配，就执行语句块1，如果没有匹配就继续与case 常量2匹配；如果一个都没有匹配上，执行default 

     **注意：**如果case语句块没有break那么从匹配到的case语句开始加上后面的case里面的语句块都会执行。（穿透）

  2. switch流程图

     ![image-20220922194739032](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220922194739032.png)

     

  3. switch细节

     1. 表达式数据类型，应和case常量**类型一致**，或者可以**自动转换**成可以相互比较的类型，比如表达式为char类型，而常量为int

     2. switch（表达式）中的表达式的返回值必须是：（byte、short、int、char、enum、String）

        ```java
        double c = 1.1;
        char c2 = 'a'
        switch(c){   //错误
        	case 1.1 : //错误
        		System.out.println("ok");
        		break;
            case c2 : //错误  变量 
            	break；
            case 'b'+1 :  //ok 常量表达式
        }
        ```

        

     3. case子句中的值必须是常量，而不能是变量

     4. default子句是可选的，当没有匹配case时，执行default

     5. break语句是用来在执行完一个case分支后使程序跳出switch语句块；没有写break，程序会顺序执行到switch结尾。（穿透）

  

#### 4.4 循环控制（while、do...while、for、多重循环）

- for循环控制
  1. 基本语法：
  
     for(循环变量初始化；循环条件；循环变量迭代){
  
     ​	循环体（语句）；
  
     }
  
  2. for循环流程图
  
     <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220923105628046.png" alt="image-20220923105628046" style="zoom: 80%;" />
  
     
  
  3. 细节说明
  
     - 循环条件返回值一定是布尔值的表达式
  
     - for( ;循环条件; )中的初始化和变量迭代可以写到其他地方，但是分号不能省。
  
       ```java
       int i = 1;
       for(;i<10;){
       	System.out.println("ok"+i);
       	i++;
       }
       for(;;){     //死循环
           System.out.println("ok");
       }
       ```
  
       
  
     - 循环初始值可以有多个初始化语句，但要求类型一致，并且用逗号隔开，循环变量迭代也可以有多条变量迭代语句，中间用逗号隔开。
  
       ```java
       int count = 9;
       for(int i = 1,j=0;i<count;i++,j+=2){
       	System.out.println("i="+i+"j="+j);
       }
       ```
  
       
  
  4. 练习
  
     编程思想：化繁为简，先死后活。
  
     - 化繁为简：将繁杂的需求拆解成简单的需求逐步完成
     - 先死后活：先考虑固定的值，然后转成可以灵活变化的值
  
     1.打印1~100之间所有是9的倍数的整数，统计个数及总和.
  
     ```java
     int count = 0;
     int sum = 0;
     int start = 1;
     int end = 100;
     int t = 9;
     for(int i=start;i <= end;i++){
         if(i % t == 0){
             count++;
             sum+=i;
             System.out.println(i+" ");
         }   
     }
     System.out.print("个数为："+count+“\n”+"总和为："+sum);
     
     ```
  
     2.完成下面的表达式输出
  
     0+5=5
  
     1+4=5
  
     2+3=5
  
     ...
  
     5+0=5
  
- while循环控制

  1. 基本语法

     循环变量初始化；

     while（循环条件）{

     ​	循环体（语句）

     ​	循环变量迭代；

     }

  2. 流程图

     ![image-20220923121856693](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220923121856693.png)

     

  3. 细节说明

     - 循环条件是返回一个布尔值的表达式
     - while循环是先判断再执行语句

  4. 练习

     1．打印1—100之间所有能被3整除的数[使用while]

     2.打印40—200之间所有的偶数[使用while]

- do...while循环控制

  1. 基本语法

     循环变量初始化；

     do{

     ​	循环体（语句);

     ​	循环变量迭代；

     }while（循环条件);

  2. 流程图

     ![image-20220923124119994](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220923124119994.png)

     

  3. 细节说明

     - 循环条件是返回一个布尔值的表达式
     - do...while循环是先执行再判断，至少执行一次

  4. 练习

     ```java
     //如果李四不还钱，张三将一直使用五连鞭，直到李四说还钱为止
     import java.util.Scanner;
     public class DoWhileExercise{
     	public static void main(String[] args) {
     		Scanner in = new Scanner(System.in);
     		String result = "n";
     		do{
     			System.out.println("李四吃我五连鞭！");
     			System.out.print("李四还不还钱？(y/n): ");
     			result = in.nextLine();
     		}while(result.equalsIgnoreCase("n") );  //比较两个字符串是否相等不区分大小写。
     		System.out.println("算你识相");
     	}
     }
     //in.next().charAt(0);  返回指定索引处的 char值。
     ```

- 多重循环

  1. 介绍

     将一个循环放在另一个循环体内---->嵌套循环(一般不超过3层)

     三种循环类型可以混合嵌套

  2.  练习

     打印九九乘法表

     ```java
     for(int i = 1;i<=9:i++){
         for(int j = 1;j<=i;j++){
             System.out.print(i+"*"+j+"="+i*j+"\t");
         }
         System.out.println();
     }
     ```

     打印空心金字塔

     ```java
     int n = 8;
     		for(int i = 1;i<=n;i++){
     			for(int j = 1;j<=n-i;j++){
     				System.out.print(" ");  //输出前面的空格
     			}
     			       
     			for(int k = 1;k<=2*i-1;k++){
     				if(k==1||k==2*i-1||i==n){
     					System.out.print("*");  //打印输出*
     				}else{
     					System.out.print(" ");
     				}				   
     			}
     			System.out.println();  //每行输出完后换行                   
     		}
     ```

     打印空心菱形

     ```
     for(int i = 1;i<=5;i++){
     			for(int j = 1;j<=5-i+1;j++){
     				System.out.print(" ");  //输出前面的空格
     			}
     			       
     			for(int k = 1;k<=2*i-1;k++){
     				if(k==1||k==2*i-1){
     					System.out.print("*");  //打印输出*
     				}else{
     					System.out.print(" ");
     				}				   
     			}
     			System.out.println();  //每行输出完后换行                   
     		}
     		for(int i = 5;i>=1;i--){
     			for(int j = 0;j<=5-i;j++){
     				System.out.print(" ");
     			}
     			for(int k =1;k<=2*i-1;k++){
     				if(k==1||k==2*i-1){
     					System.out.print("*");
     				}else{
     					System.out.print(" ");
     				}				
     			}
     			System.out.println();
     		}
     ```

     

#### 4.5 break

- 应用场景

  请看以下需求：

  随机生成1-100的一个整数，直到生成了97这个数，看看你一共用了几次?提示使用(int)(Math.random()* 100)+ 1

  ```java
  import java.lang.Math;
  public class BreakTest{
  	public static void main(String[] args) {
  		int i = 0;
  		int x =97;
  		while(true){
  			System.out.println(++i);
  			if(x==(int)(Math.random()*100+1)){
  				break;
  			}
  		}
  	}
  }
  ```

  

- 基本介绍

  break语句用于终止某个语句块的执行，一般使用在switch或者循环【for，while，do-while】中。

- 基本语法

  {

  ​	......

  ​	break;

  ​	......

  }

- 以while使用break为例，画图：

  <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220924013635966.png" alt="image-20220924013635966" style="zoom:67%;" />

  

- 注意事项和细节说明

  1. break语句出现在多层嵌套的语句块时，可以通过标签指明要终止的是哪一层语句块

  2. 标签的基本使用

     label1：{

     label2：			{

     label3：						{

     ​												break label2；

     ​										}							

     ​							}

     ​				}

     **解读：**

     1. break语句可以指定退出哪层；
     2. label1是标签，名字由程序员指定；
     3. break后指定到哪个label就退出到哪里；
     4. 在实际开发中，尽量不要使用标签；
     5. 如果没有指定break，就默认退出最近的循环体；

     **代码演示**

     ```java
     label1:
     for(int j = 0;j<4;j++){
     label2:
         for(int i = 0;i<10;i++){
             if(i == 2){
                 break label1;
             }
             System.out.println("i="+i);
         }
     }
     ```

     



#### 4.6 continue

- 基本介绍

  1. ocntinue语句用于结束本次循环，继续执行下一次循环。
  2. continue语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环。

- 流程图

  <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220924142907247.png" alt="image-20220924142907247" style="zoom:67%;" />

- 案例

  ```java
  public class Continue01{
      public static void main(String[] args){
          int i = 1;
          while(i<=4){
              i++;
              if(i == 2){
                  continue;
              }
              System.out.println("i="+i); //3 4 5
          }
      }
  }
  ```

- 



#### 4.7 return



### 5  数组

#### 5.1 数组

- 介绍

  数组可以存放多个同一类型的数据。数组也是一种数据类型，是引用类型。

- 使用方式

  1. 动态初始化1

     数据类型[ ] 数组名 = new 数据类型[大小];

     int a[ ] = new int[5]; //创建了一个数组，名字为a,存放5个int

     

  2. 动态初始化2

     先声明：

     数据类型 数组名[ ]; == 数据类型[ ] 数组名;

     int a[ ]; 或者 int[] a;

     再创建：

     数组名  =  new 数据类型[大小];

     a = new int[10];

  3. 静态初始化：

     数据类型 数组名[] = {元素值1，元素值2，...}

- 注意事项和细节

  1. 数组是多个相同类型数据的组合，实现对这些数据的统一管理。

  2. 数组中的元素可以是任意数据类型，包括基本类型和引用类型，但不违背第一条。

  3. **数组创建后，如果没有赋值，有默认值**（int,short,byte,long）0,(float,double)0.0,(char)\u0000,boolean->false,String->null.

  4. 使用数组的步骤1.声明数组并开辟空间2给数组各个元素赋值3使用数组。

  5. 数组的下标是从0开始的。

  6. 数组下标必须在指定范围内使用,否则报:下标越界异常，比如

     int [ ] arr=new int[5;则有效下标为0-4

  7. 数组属引用类型,数组型数据是对象(object)

- 应用案例

  1. 创建一个char类型的26个元素的数组，分别放置'A'-'Z。使用for循环访问所有元素并打印出来。提示: char类型数据运算'A'+1-> 'B' ArrayExercise01.java

     ```java
     public class  ArrayExercise01{
     	public static void main(String[] args) {
     		char[] arr1 = new char[26];	
     		for(int i = 0;i<arr1.length;i++){  //注意范围是小于数组长度不能写成小于等于
     			arr1[i] = (char)('A' + i);    //注意要强制转换
     		}
     		for (int i = 0;i<arr1.length;i++){
     			System.out.print(arr1[i]+" ");
     		}
     	}
     }
     ```

     

  2. 请求出一个数组int[]的最大值{4,-1,9, 10,23}, 并得到对应的下标。ArrayExercise02.java

    ```java
    public class ArrayExercise02{
    	public static void main(String[] args) {
    		int[] intsarr ={4,-1,9,10,23};
    		int index =0 ;
    		int max = 0; 
    		for (int i = 0;i < intsarr.length-1;i++ ) {
    			if(intsarr[i] <= intsarr[i+1]){
    				index = i+1;
    				max =intsarr[i+1];
    			}else{
    				index = i;
    				max =intsarr[i];
    			}
    		}					System.out.println("max="+max+"\n"+"index="+index);
    	}
    }
    ```

    

- 数组赋值机制

  1. 基本数据类型赋值，指的是具体数值，而两个变量互不影响。

  2. 数组在默认情况下是引用传递，赋的值是地址。案例：

     ```java
     	public static void main(String[] args) {
     		int a = 1;
     		int b = a;//只赋值了数值两个变量互不影响；
     		a = 3;
     		System.out.println("a="+a+"\n"+"b="+b);
     		int[] arr1 = {1,2,3}; //赋值为地址，引用传递
     		int[] arr2 = arr1; //arr1和arr2同时管理{1,2,3}
     		arr2[1] = 3;      //数组{1,2,3}已经变成{1,3,3}
     		System.out.println("arr1[1]="+arr1[1]+"\n"+"arr2[1]="+arr2[1]);
     	}
     }
     ```

     

  3. 值传递(值拷贝)和引用传递（地址拷贝）的区别

     int n1 =10; int n2 = n1; n2=80;

     int[] arr1 = {1,2,3}; int[] arr2 = arr1; arr2[1] = 3;

     ![](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20220927020817933.png)

     

- 数组反转

  要求：把数组的元素内容反转。

  arr{11,22,33,44,55,66}->{66,55,44,33,22,11}

  方法一：原数组交换

  ```java
  public class ArrayReverse{
  	public static void main(String[] args) {
  		int[] arr = {11,22,33,44,55,66,0};
  		int temp = 0; 
  		for (int i = arr.length-1,j = 0;i >= arr.length/2 ;i--,j++) {			
  			temp = arr[i];
  			arr[i] = arr[j];
  			arr[j] = temp;
  		}
  		for (int i = 0;i <arr.length ;i++ ) {
  			System.out.println(arr[i]+" ");		
  		}
  	}
  }
  ```

  

  方法二：逆序赋值，新创一个数组

  ```java
  public  class ArrayReverse02{
  	public static void main(String[] args) {
  		int[] arr = {11,22,33,44,55,66};
  		int len = arr.length;
  		int[] arr2 = new int[len];
  		for (int i = len - 1,j = 0;i >= 0;i--,j++ ) {
  			arr2[j] = arr[i];
  		}
  		System.out.println("======以下为arr数组======");
  		for (int i = 0;i < len ;i++ ) {
  			System.out.println(arr[i]);
  		}
  		System.out.println("======以下为arr2数组======");
  		for (int i = 0;i < len ;i++ ) {
  			System.out.println(arr2[i]);
  		}
  	}
  }
  ```

  

- 数组扩容

  案例：实现动态的给数组添加元素效果

  ```java
  import java.util.Scanner;
  public class ArrayAdd{
  	public static void main(String[] args) {
  		//int[] arr = {1,2,3,4};
  		//要求实现arr数组增加每次增加一个数字，
  		//思路：新建一个数字 int[] newArr[] = new int[arr.length+1];
  		//先遍历arr数组把原有的元素进行拷贝最后一个进行赋值；
  		//赋值可以进行判断是否要继续赋值
  		//然后再把操作后的newArr数组引用到arr数组上
  		int[] arr = {1,2,3,4,5,6};
  		char result = 'n';
  		int add = 0; 
  		Scanner in = new Scanner(System.in);
  		t1: while(true){	
  				int[] newArr = new int[arr.length+1];
  				for (int i = 0;i < arr.length+1;i++) {
  					if(i == arr.length){
  						System.out.println("请问你还要添加吗（每次添加一个数字）n/y : ");
  						result = in.next().charAt(0);
  						if(result == 'y'){
  							System.out.println("请输入你要添加的一个数字: ");
  							add = in.nextInt();
  							newArr[arr.length] = add;
  							arr = newArr;
  							continue t1;
  						}else{
  							//arr = newArr;
  							break t1;
  						}					
  					}else{
  						newArr[i]=arr[i];
  					}					
  				}
  			}
  		System.out.println("---------现arr里的数值有-------- ");
  		for (int i = 0 ;i < arr.length ;i++ ) {
  			System.out.print(arr[i]+" ");
  		}
  	}
  }
  ```

  优化见02；

- 数组缩减

  ```java
  import java.util.Scanner;
  public class ArrayReduce{
  	public static void main(String[] args) {
  		Scanner in = new Scanner(System.in);
  		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
  		while(true){
  			int[] arrRd = new int[arr.length-1];
  			for (int i = 0;i < arrRd.length;i++ ) {
  				arrRd[i] = arr[i];
  			}
              arr = arrRd;
              System.out.println("-------删除后的数组如下------");
              for (int i = 0;i < arrRd.length;i++ ) {
  				System.out.print(arr[i]+" ");
  			}
  			if(arr.length == 1){
  				System.out.println("\n数组arr只剩下最后一个元素了不能再删除了！");
  				break;
  			}
  			System.out.println("\n是否继续删除？(y/n)：");
  			if (in.next().charAt(0) != 'y') {
  				break;
  			}
  		}
  		System.out.println("你已经退出删除！");
  	}
  }
  ```



#### 5.2 排序

- 排序介绍

  排序是将多个数据，依指定的顺序进行排列的过程。

  排序的分类:
  **1.内部排序:**
  指将需要处理的所有数据都加载到内部存储器中进行排序。包括(交换式排序法、选择式排序法和插入式排序法);
  **2.外部排序法:**
  数据量过大，无法全部加载到内存中，需要借助外部存储进行排序。包括(合并排序法和直接合并排序法)。

- 冒泡排序法

  冒泡排序(Bubble Sorting)的基本思想是:通过对待排序序列从后向前(从下标较大的元素开始），依次**比较相邻元素的值**，若发现逆序则交换,使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。

- 冒泡排序案例

  将五个无序：24，51，15，645，6 使用冒泡排序法将其排成从小到大的有序数列。

  ```java
  public class BubbleSort{
  	public static void main(String[] args) {
  		//将五个无序：24,51,15,645,6 
  		//使用冒泡排序法将其排成从小到大的有序数列。
  		//思路：有分析可知需要四轮比较方可排好序。
  		//第一轮需要五个数一一比较共比较四次
  		//第二轮比较只要比四个数因为进过第一轮比较后最大数已经在最后了
  		//以此类推
  		//最终到只剩下两个数再比较一次就行了
  		//时间复杂度为O(n2)
  		//特别注意：要关注每一个i的取值范围考虑数组边界
  		int[] arr = {24,51,15,645,6};
  		for (int i = arr.length-1;i>= 0;i-- ) {
  			for (int j = 0;j < i;j++) {
  				if (arr[j] > arr[j+1]) {
  					int temp = arr[j];
  					arr[j] = arr[j+1];
  					arr[j+1] = temp;
  				}
  			}
  		}
  			
  		for (int i = 0;i < arr.length;i++ ) {
  			System.out.print(arr[i]+" ");
  		}
  	}
  }
  
  ```

  

#### 5.3 查找

- 介绍

  1. 顺序查找
  2. 二分查找

- 案例演示

  1. 有一个数列:白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王 猜数游戏:从键盘中任意输入一个名称，判断数列中是否包含此名称【顺序查找】要求:如果找到了，就提示找到，并给出下标值。

  ```java
  /*
  有一个数列:白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王 
  猜数游戏:从键盘中任意输入一个名称，
  判断数列中是否包含此名称【顺序查找】
  要求:如果找到了，就提示找到，并给出下标值。
   */
  import java.util.Scanner;
  public class SeqSearch {
  	public static void main(String[] args) {
  		boolean result = false; //设置标志来标记是否找到
  		int index = 0;  //提出索引位置
          //以上两步做法都是便于后面的输出。
  		String[] arr = {"白眉鹰王","金毛狮王","紫衫龙王","青翼蝠王"};
  		Scanner in = new Scanner(System.in);
  		System.out.print("请输入你猜的名字： "); 
  		String s = in.nextLine();
  		for (int i = 0;i < arr.length;i++ ) {
  			if(s.equals(arr[i])){
  				result = true;
  				index = i + 1;
  			}
  			
  		}
  		if(result){
  			System.out.println("你输入的对了他在第"+index+"个!");
  		}
  		else{
  			System.out.println("你输入的不对!");
  		}
  				
  	}
  }
  ```

  

  2. 请对一个有序数组进行二分查找{1,8,10,89,1000,1234}，输入一个数看看该数组是否存在此数，并且求出下标，如果没有就提示"没有这个数"。

  ```java
  
  ```

  

#### 5.4 二维数组

- 二维数组的使用

  1. 使用方式1：动态初始化

     语法：类型[ ] [ ]数组名 = new 类型[大小] [大小]

     

     

  2. 

- 





### 6 面向对象入门

#### 6.1 类与对象

##### 6.1.1 类与对象概述

1. 类就是数据类型（自定义）-->规定**属性和行为**
2. 对象就是一个具体的实例，对象实例化类的**属性和行为**

##### 6.1.2 类与对象入门

1. ​	案例：张老太养了两只猫猫:一只名字叫小白,今年3岁,白色。还有一只叫小花,今年100岁,花色。请编写一个程序，当用户输入小猫的名字时，就显示该猫的名字，年龄，颜色。如果用户输入的小猫名错误，则显示张老太没有这只猫猫。

2. 代码实现：

   ```java
   public class Object01{
   	public static void main(String[] args) {
   		//实例化一个猫类，（创建一个猫对象）
   		Cat cat1 = new Cat();   //将实例化的对象赋值给cat1
   		cat1.name = "小白";     //获取类的属性
   		cat1.age = 3;
   		cat1.color = "白色";
   		System.out.println("名字："+cat1.name+"\n年龄："+cat1.age+"\n颜色："+cat1.color);
   		cat1.acting();  //获取类的方法
   
   		Cat cat2 = new Cat();   //将实例化的对象赋值给cat2
   		cat1.name = "小花";     //获取类的属性
   		cat1.age = 100;
   		cat1.color = "花色";
   	}
   }
   //定义猫类 属性+行为（方法）
   class Cat{
   	String name; //属性1
   	int age;     //属性2
   	String color;  //属性3
   	//定义行为
   	public void acting(){
   		System.out.println("我会抓老鼠！");
   	}
   }
   ```

   

3. 如何创建对象

   - 先声明再创建

     Cat cat1;     //声明对象在栈里面，没有分配空间

     cat1 = new Cat();     //创建在堆里面开辟空间

   - 直接创建

     Cat cat1 = new Cat();

2. 



##### 6.1.3 类与对象内存布局与分配机制

布局：

​	![image-20221009165747469](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221009165747469.png)

数据类型不同存放地址不同，引用类字符串在方法区常量池，基本数据类型在堆。

new的时候方法区就会加载类的信息（属性+方法）

```java
Person p1 = new Person();
p1.age = 10;
p1.name = "小米";
Person p2 = p1;
System.out.println(p2.age);
```

同数组为引用赋值同时指向该对象，内存图如下:

![image-20221009181947918](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221009181947918.png)

流程分析：

1. 先在方法区加载类信息
2. 在堆中分配空间，进行默认初始化
3. 把地址赋给初始化的对象名，该对象名就指向对象
4. 进行指定初始化，如：p.name = "小米" 

分配机制：

1. 栈：一般存放基本数据类型（局部变量）
2. 堆：存放对象，引用类数据类型
3. 方法区：常量池（常量，字符串等），类加载信息（只会加载一次）

##### 6.1.4 属性/成员变量

基本介绍

1. 成员变量 = 属性 = field （字段）。
2. 属性是类的一个组成部分，一般是基本数据类型，也可以是引用数据类型（对象，数组）。

细节与注意事项

1. 定义语法：访问修饰符  属性类型  属性名；

   访问修饰符有：public default protected private（访问权限）

2. 类型可以为任意。

3. 属性如果不赋值，有默认值。

#### 6.2  成员方法

##### 6.2.1 方法的介绍与入门

1. 基本介绍：

   在某些情况下，我们需要定义成员方法（简称方法）。比如人类：除了一些属性外（年龄，姓名...），我们还有一些行为：说话、跑步、学习等，这时候就需要成员方法来定义了。

2. 方法入门

   对人类进行完善添加方法：

   - 添加speak成员方法，输出 我是一只好人
   - 添加cal01成员方法，可以计算从 1+...+1000的结果
   - 添加cal02成员方法，该方法可以接收一个数n ,计算从1+...+n的结果
   - 添加getSum成员方法，可以计算两个数的和。

   ```java
   public class Method01 {
   	public static void main(String[] args) {
   		Person p1 = new Person();
   		p1.name = "小帅";
   		p1.age = 20;
   		p1.sex = "男";
   		p1.ifoShow();
   		p1.speak();
   		p1.cal01();
   		p1.cal02(100);
   		p1.getSum(10,28);
   	}
   }
   
   class Person{
   	String name;
   	int age;
   	String sex;
   	//添加人的信息显示方法ifoShow；
   	public void ifoShow(){
   		System.out.println("姓名："+name+"\n年龄："+age+"\n性别："+sex);
   	}
   	//添加speak成员方法，输出 我是一只好人
   	public void speak(){
   		System.out.println("我是一只好人!");
   	}
   	//添加cal01成员方法，可以计算从 1+...+1000的结果
   	public void cal01(){
   		int result = 0;
   		for (int i = 1;i <= 1000;i++ ) {
   			result += i;
   		}
   		System.out.println("1+...+1000="+result);
   	}
   	//添加cal02成员方法，该方法可以接收一个数n ,计算从1+...+n的结果
   	public void cal02(int n){
   		int result = 0;
   		for (int i = 1;i <= n;i++) {
   			result += i;
   		}
   		System.out.printf("1+...+%d="+result+"\n",n);
   	}
   	//添加getSum成员方法，可以计算两个数的和。
   	public void getSum(double a,double b){
   		double sum = a + b;
   		System.out.println(a+"+"+b+"="+sum);		
   	}
   }
   ```

   

3. 方法的调用机制原理

     ![image-20221009205835608](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221009205835608.png)

   

4. 成员方法的好处

   - 提高代码的复用性。
   - 可以将实现的细节封装起来，然后供其他用户来调用即可。

##### 6.2.2 方法的定义与使用细节

1. 定义形式：

   访问修饰符 返回数据类型  方法名  （型参列表...）{//方法体

   ​	语句;

   ​	return  返回值;

   }

2. 使用细节

   - 一个方法最多只能有一个返回值
   - 返回类型可以为任意数据类型
   - 如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return  值 ; 而且要求返回值类型必须和return的**值一致**或者**兼容**（符合**自动转换**）低精度-->高精度
   - 如果返回类型为viod，则方法体中可以没有return，或者只写return
   - 方法名遵循驼峰命名法，最好见名知意

3. 形参列表细节

   - 一个方法可以有0个参数，也可以有多个参数，每个参数之间用逗号隔开
   - 参数类型为任意
   - 调用带参数的方法时，一定注意要对应形参列表类型传入**相同类型和兼容类型**的实参
   - **实参与形参的类型要一致或者兼容、个数、顺序必须一致**

4. 方法体细节

   - 方法体里面不能再定义方法！即**方法不能嵌套定义**。
   - 方法体里可以调用方法

5. 方法调用细节

   - 同一个类中的方法调用：直接调用即可；比如：**方法名（参数）;**
   - 跨类中的方法A类调用B类方法：需要通过对象名调用。比如**对象名.方法名（参数）;**
   - 特别说明跨类的方法调用和方法的访问修饰符相关

##### 6.2.3 成员方法的传参机制

1. 基本数据类型传参机制

   案例：两数交换

   ```java
   public class Mathodparameter01 {
   	public static void main(String[] args) {
   		int a = 10;
   		int b = 20;
   		System.out.println("这是调用swap前，main中的a和b\n a="+a+" b="+b);
   		AA aa = new AA();
   		aa.swap(a,b);
   		System.out.println("这是调用swap后，main中的a和b\n a="+a+" b="+b);
   	}
   }
   
   class AA{
   	public void swap(int a,int b){
   		int temp;
   		System.out.println("这是swap中交换前的a和b\n a="+a+" b="+b);
   		temp = a;
   		a = b;
   		b = temp;
   		System.out.println("这是swap中交换后的a和b\n a="+a+" b="+b);
   		
   	}
   }
   ```

   ![image-20221010162022311](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010162022311.png)

   结论：**基本数据**类型，传递的是值（值拷贝），形参的任何改变不影响实参！独立栈

2. 引用数据类型的传参机制

   案例1：B类中编写一个方法test100，可以接收一个数组，在方法中修改该数组，看看原来的数组是否变化?
   

   ```java
   public class Mathodparameter02{
   	public static void main(String[] args) {
   		B bb = new B();
   		int[] arr = {1,2,3};
   		bb.test1(arr);
   		System.out.println("\n这是main里面的arr：");
   		for (int i : arr ) {
   			System.out.print(i+" ");
   		}
   	}
   }
   class B{
   	public void test1(int[] arr){
   		arr[0] = 200;
   		//遍历数组
   		System.out.println("这是test1里面的arr：");
   		for ( int i : arr ) {
   			System.out.print(i+" ");
   		}
   	}
   }
   ```

   ![image-20221010162056069](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010162056069.png)

   案例2：B类中编写一个方法test200，可以接收一个Person(age,sal)对象，在方法中修改该对象属性，看看原来的对象是否变化?

   ```java
   class Preson{
       String name;
       int age;
   }
   class B{
       public void test2(Preson p){
           p.age = 100;
       }
   }
   ```

   ![image-20221010163418131](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010163418131.png)

   结论：引用类型传递的是地址（传递的也是值，但是这个值是地址），可以通过形参影响实参！

3. **思考**：

   ![image-20221010164854484](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010164854484.png)

   ![image-20221010164935584](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010164935584.png)

   //以上输出p为10；

   **分析：当调用test2时main中的p与test2中的p都指向堆空间里的Preson对象，但执行 p = null; 时表示把test2中的p指向了一个空。不影响main中的p**

   ![image-20221010165821138](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010165821138.png)

   ![image-20221010165847461](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221010165847461.png)

   //输出 10 100 10

   **分析：当调用test2时main中的p与test2中的p都指向堆空间里的Preson对象，但执行 p =  new Preson ; 时相当于把p指向了一个新的Preson对象这个对象与mian里的p指向的对象是两个对象在堆里面有自己的空间互不干扰 **

#### 6.3 方法的递归

##### 6.3.1基本介绍

​	递归就是方法自己调用自己，每次调用时传入不同变量。注意递归不能死循环要有出口。

##### 6.3.2 递归解决什么问题

1. 各种数学问题,如：8皇后，汉诺塔，阶乘，迷宫，球和篮子等
2. 各种算法，如：快排，归并排序，二分查找等
3. 将用栈解决的问题--->递归代码比较简洁

##### 6.3.3 方法递归调用机制分析

1. 代码1：

   ```java
   public void test1(int n){
   	if(n >= 2){
   		test1(n - 1);
   	}
   	System.out.println("n="+n);
   }
   //当n=4时
   //输出 1 2 3 4
   
   ```

   分析：先调用最后放回时才一一输出

   ![image-20221011174040801](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221011174040801.png)

   

2. 代码2

   ```java
   public void test2(int n){
   	System.out.println("n="+n);
   	if(n >= 2){
   		test2(n - 1);
   	}	
   }
   //4 3 2 1
   ```

   分析：先执行输出语句在进行递归调用。

3. 代码3

   ```java
   public int factorial(int n){
   	if(n == 1){
   		return  1;
   	} else {
   		return n * factorial(n-1);
   	}	
   }
   ```

   <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221012010531929.png" alt="image-20221012010531929" style="zoom:80%;" />

   **注意：每一个return返回到调用的位置，这个相当于先求1！->2!   -->3!--...-->n!**

##### 6.3.4  方法递归调用的规则

1. 执行一个方法时，就创建一个新的受保护的（独立空间）栈空间
2. 方法的局部变量是独立的，不会互相影响
3. 如果方法中使用的是引用数据类型变量（数组，对象）就会共享该引用类型的数据
4. 递归必须向退出递归的条件靠拢（要有出口），否则无限递归，报错StackOverflowError
5. 当一个方法执行完毕，或者遇到return就会返回，遵循哪里调用就回到哪里

##### 6.3.5 递归案例练习

1. 斐波那契数列：1 1 2 3 5 8 13 ... 给整数n ，求它的值是多少

   思路分析：

   当 n =1斐波那契数是 1

   当 n =2斐波那契数是 1

   当 n >=3斐波那契数是 前两个数之和

   **要想的到想要的数就得先知道他前面的两个数直到到达最前面两个确定的数既可以使用递归**

   当n = 1，2时返回 1

   当n >= 3 时返回前两个自己相加

   ```java
   public class RecursionExercise01 {
   	public static void main(String[] args) {
   		T t1 = new T();
   		int n = 10;
   		int result = t1.fibonacci(n);
   		if(result != -1){
   			System.out.println("第"+n+"个斐波那契数为："+result);
   		}
   		
   	}
   }
   
   class T{
   	public int fibonacci(int n){
   		if(n > 0){
   			if(n == 1 || n == 2){
   				return 1;
   			}else{
   				return fibonacci(n-1) + fibonacci(n-2);
   			}
   		} else {
   			System.out.println("请输入大于0的整数!");
   			return -1;
   		}
   	}
   }
   ```

   

2. 猴子吃桃：有一堆桃子猴子第一天吃了其中的一半，并再多吃了一个！以后每天猴子都吃其中的一半，然后再多吃一个。当到第十天时，（还没吃）发现还有一个桃子了。问题最初一共多少个桃子？

   思路分析：

   第十天剩一个桃

   第九天 = （第十天+1）*2

   第八天=（第九天+1）*2   

   ...

   逆推递归

   ```Java
   public int peach(int day) {
   	if(day == 10) {
   		return 1;
   	} else if(day >= 1 && day <= 9) {
   		return peach(day+1) * 2+2;
   	} else {
   		System.out.println("请输入天数在1~9之间！");
   		return -1;
   	}
   }
   ```

   

3. 迷宫问题

   小球得到的路径，和程序员设置的找路策略有关即:找路的上下左右的顺序相关
   再得到小球路径时，可以先使用(下右上左),再改成(上右下左)，看看路径是不是有变化测试回溯现象
   扩展思考:如何求出最短路径?

   <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221012122816743.png" alt="image-20221012122816743" style="zoom:50%;" />

   ```java
   public class MiGong {
   	public static void main(String[] args) {
   		//1.用二维数组表示迷宫 1为障碍物 0为通路
   		//2.定义二维数组int[][] map = new int[7][6];8行7列。
   		int[][] map = new int[8][7];
   		//3.第一行和最后一行全为1 ，map[0][i] = 1;map[7][i] = 1;
   		for (int i = 0;i < 7 ;i++ ) {
   			map[0][i] = 1;
   			map[7][i] = 1;
   		}
   		//4.第一列和最后一列全为1 ，map[i][0] = 1;map[i][6] = 1;
   		for (int i = 0;i < 8 ;i++ ) {
   			map[i][0] = 1;
   			map[i][6] = 1;						
   		}
   		//5.单独设置map[3][1] = 1;map[3][2] = 1;迷宫搭建完成
   		map[3][1] = 1;
   		map[3][2] = 1;
   		//回溯
   		map[2][2] = 1;
   		//6.查看结果
   		for (int[] i :map ) {  //把二维数组一行一行遍历成一维数组保存在int[] i 中
   			for (int j :i ) {   //再把一维数组i进行遍历保存在int j中
   				System.out.print(j+" ");
   			}
   			System.out.println();
   		}
   		System.out.println("-------------------------");
   		System.out.println("找的路如下：");
   		//利用findWay方法找路
   		T t1 = new T();
   		t1.findWay(map,1,1);
   		//由于数值为引用数据类型，上下互相影响。这时候可以根据数值的含义再次输出数值查看。
   		for (int[] i :map ) {  //把二维数组一行一行遍历成一维数组保存在int[] i 中
   			for (int j :i ) {   //再把一维数组i进行遍历保存在int j中
   				System.out.print(j+" ");
   			}
   			System.out.println();
   		}
   	}
   }
   
   class T{
   	//使用递归回溯的思想来解决老鼠出迷宫
   	//1.findWay方法用于找路
   	//2.如果找到，就返回true否则返回false
   	//3.参数map表示地图 ，i，j表示老鼠的位置，初始化位置为（1，1）
   	//4.因为是递归找路，所以要找出递归出口。所以先规定map数组中各个数值的含义
   	//  0表示可以走也没走过，1表示障碍物，2表示可以走后面还有路，3表示走过，但是走不通是死路
   	//5.当map[6][5] = 2就说明找到通路了就可以退出了，否则就继续找。  
   	//6.先确定老鼠找路的策略 下-->右-->上-->左
   	public boolean findWay(int[][] map,int i,int j){
   		//先判断map[6][5] == 2 ？
   		if (map[6][5] == 2) {   //表示已经找到
   			return true;
   		} else{
   			if(map[i][j] == 0) {      
   				map[i][j] = 2;    //假定该位置还有路先标为2 
   		//再利用找路的策略 下-->右-->上-->左 进行探测来判断是否有路，这里重复了功能可以递归
   				if(findWay(map,i+1,j) ){        //上
   					return true;
   				}else if(findWay(map,i,j+1) ){  //右
   					return true;
   				}else if(findWay(map,i-1,j) ){  //下
   					return true;
   				}else if(findWay(map,i,j-1)){   //左
   					return true;
   				}else{  //探测完毕走不通说明上面的假定有误，应该是死路标为3
   					map[i][j] = 3;
   					return false;
   				}
   			}else{   //1 2 3 都不需要再探测
   				return false;
   			}
   		} 
   	}
   }
   ```

   

4. 汉诺塔

   ```java
   public class HanNuoTa {
   	public static void main(String[] args) {
   		Tower t1 = new Tower();
   		int layers = 5;  //定义层数
   		t1.move(layers,'A','B','C');
   	}
   }
   class Tower{
   	public void move(int layers,char a,char b,char c){  
   	//参数说明：n表示盘个数，a b c表示塔
   	//就看成两种情况一个盘；和除了一个盘上面的全看出一个盘  递归		     
   		if(layers == 1){
   			System.out.println(a+"->"+c);
   		}else{
   			move(layers-1,a,c,b);  //把上面的盘借助c塔移到b塔
   			System.out.println(a+"->"+c);  //移完后再把最后一个盘移到c塔
   			move(layers-1,b,a,c);	 //再把上面的盘借助a塔移到c塔		
   		}		
   	}
   }
   ```

   

5. 八皇后（回溯）

   即:任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。

   思路分析：

   第一个皇后先放第一行第一列

   第二个皇后放在第二行第一列、然后判断是否OK，如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适的位置。

   继续第三个皇后，还是第一列、第二列..…..直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解

   当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.

   然后回头继续第一个皇后放第二列，后面继续循环执行1,2.3.4的步骤【示意图】

   **说明:**理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] ={0，4,7,5.2,6,1,3}//对应arr下标表示第几行，即第几个皇后，arr[ti]= val , val表示第i+1个皇后，放在第i+1行的第val+1列

   ```java
   public class EightQueens {
   	public static void main(String[] args) {
   		int[] site = new int[8]; 
   		T t1 = new T();
   		t1.row(site,0); //从第一个开始放，位置存放在site数组中。
   	}
   }
   class T{
   
   	//放置棋子函数
   	public void row(int[] site,int n ){
   		int max = 8;       //最多有八个棋子
   		if(n == 8){	       //n=8时说明8个棋子已经放完了，					
   			print(site);   //这里注意当n=7时就已经放完然后再调用row(n+1)时才n=8就可以输出了。
   			return;
   		}
   		for (int i = 0;i < max ;i++ ) {
   			site[n] = i;        //放下棋子从第一个位置开始放直到可以为止
   			if(judge(site,n)){  //判断位置是否可以
   				row(site,n+1);  //递归，放好第n个棋子后就放第n+1个棋子
   			}
   		}	
   
   	}
   	//判断函数
   	public boolean judge(int[] site,int n){
   		for (int i = 0;i<n ;i++ ) {    //只需要判断第0个到第n个棋子就行了
   			//判断是否为同一列，同一斜线上。Math.abs()是求绝对值函数
   			//site[i]表示前面棋子放下的位置，site[n]表示刚刚第n个棋子放下的位置
   			if(site[i] == site[n] || Math.abs(i - n) == Math.abs(site[i] - site[n])){
   				return false;
   			}
   		}
   		return true;
   	}
   	//输出函数
   	public void print(int[] site){		
   		for (int i :site ) {
   			System.out.print((i+1)+" "); //正常思维位置+1
   		}
   		System.out.println();
   
   	}
   }
   
   ```

   

#### 6.4 方法的重载

##### 6.4.1 快速入门

1. 基本介绍

   Java中允许同一个类中，多个同名的方法存在，但是要求**“形参列表不一致（类型，数量）”**比如System.out.println()可以输出很多类型这种现象就叫方法重载。

2. 特别说明：**不一致**只对**形参列表来说与返回类型无关**形参不一致分了三种情况**形参个数，个数一样看形参类型，前两个都一样看顺序**

3. 重载好处

   减轻起名以及记名的麻烦，有利于接口编程

4. 快速入门案例

   OverLoad01.java

   类：MyCalculator 方法： calculate

   calculate(int n1,int n2) //两个整数的和

   calculate(int n1,double n2) //一个整数和一个double数的和

   calculate(int n1,int n2，int n3) //三个整数的和

   calculate(int n1,double n2) //一个double数和一个整数的和

   ```java
   public class OverLoad01 {
   	public static void main(String[] args) {
   		MyCalculator mc = new MyCalculator();
   		mc.calculate(10,10);      //方法①
   		mc.calculate(10,10.1);    //方法②
   		mc.calculate(10,10,10);   //方法③
   		mc.calculate(10.1,10);    //方法④ 
   
   	}
   }
   
   class MyCalculator{
   	//方法①，两个整数的和
   	public void calculate(int n1, int n2){    
   		System.out.println(n1 +n2 );
   	} 
   	//方法②， 一个整数和一个double数的和
   	public void calculate(int n1, double n2) {
   		System.out.println(n1 +n2 );
   	}
   	//方法③，三个整数的和
   	public void calculate(int n1, int n2, int n3){
   		System.out.println(n1 +n2 +n3 );
   	}
   	//方法④ ，一个double数和一个整数的和
   	public void calculate(double n1, int n2){
   		System.out.println(n1 +n2 );
   	}
   } 
   
   ```

   

##### 6.4.2 方法重载细节说明

1. 方法名：必须相同
2. 形参列表：必须至少一个不同（个数，类型，顺序）
3. 返回类型：没要求（无关）
4. 参数名：没要求（无关）所以就参数名不同不能构成重载
5. 如何判断：调用时能否区分是哪个方法

#### 6.5 可变参数

##### 6.5.1 what

1. 基本概念：

   java允许将同一个类中**多个同名同功能参数类型相同**但**参数个数不同**的方法，**封装**成一个方法。

2. 基本语法：

   访问修饰符    返回类型    方法名(数据类型...  形参名){

   }  //不要把...看成写多个数据类型就是 “ ... ” 

3. 入门案例：

   类Method方法sum【可计算2，3，4，5...个数的和】

   ```java
   public class VarParameter01 {
   	public static void main(String[] args) {
   		Method m = new Method();
   		int result = m.sums(1,2,4,56,7,87);
   		System.out.println(result);
   	}
   }
   //实现1，2，3，4，5。。。。。。个数的和
   class Method{
   	//两个数和
   	public int sum(int m, int n){
   		return m + n;
   	}
   	//三个数和
   	public int sum(int m, int n, int p ){
   		return m + n + p;
   	}
   	//......
   	//发现以上方法名相同，形参类型相同，功能也相同可以使用可变参数进行封装如下：	
   	public int sums(int... n){   //int... 表示可以接收多个（0-n）int类型的参数。
   		//使用时可以把n当成数组来使用；
   		/*
   		System.out.println("接收的参数个数为：" + n.length);
   		for (int i :n ) {
   			System.out.println(i);
   		}
   		*/
   		//完成加法运算，
   		int sum = 0;
   		for (int i = 0;i < n.length ;i++ ) {
   			sum += n[i];
   		}
   		return sum;
   	}
   }
   ```

   

##### 6.5.2 可变参数细节

1. 可变参数的实参可以为0个或者任意多个

2. 可变参数的实参可以为数组

3. 可变参数的本质就是数组

4. **可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后**

5. 一个形参列表中只能出现一个可变参数

   ```java
   public class VarParameterDetail {
   	public static void main(String[] args) {
   		T t1 = new T();
   		//1.可变参数的实参可以为数组
   		int[] n = {1,2,3,4,5};
   		t1.f1(n);
   		t1.f2("sy",1,2,3,4,5,6);
   	}
   }
   class T{
   	public void f1(int... nums){}
   	//2.可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
   	public void f2(String a, int... nums){}
   	//3.一个形参列表中只能出现一个可变参数
   	//public void f2(String a, int... nums,byte... b){}  错误不允许多个可变参数类型
   
   }
   ```

#### 6.6 作用域

##### 6.6.1 基本使用

1. 在java编程中，主要的变量就是属性（成员变量）和局部变量。
2. **局部变量**一般是指在**成员方法**里面定义的变量而**成员变量**时定义在**类**里面的变量。
3. Java中作用域的分类
   - 成员变量：也就是属性，作用域为整个类体
   - 局部变量：也就是除了属性之外的其他变量，作用域为定义它的代码块中！
4. 全局变量（属性）可以不赋值，直接使用，因为有默认值，局部变量必须赋值后才能使用，因为没有默认值

##### 6.6.2 细节说明

1. 属性和局部变量可以重名，访问时遵循就近原则。

2. 在同一个作用域中，比如在同一个成员方法中，两个局部变量，不能重名。

3. 属性生命周期较长，伴随着对象的创建而创建，销毁而销毁。局部变量生命周期较短，伴随它的代码块的执行而创建，代码块的结束而死亡。

4. 作用范围不同

   - 全局变量/属性：可以被本类所用，也可以被其他类使用（对象调用如：preson.name）
   - 局部变量：只能在本类中对应的方法里使用

5. 修饰符不一样

   - 全局变量可以加修饰符
   - 局部变量不可以加修饰符

   ```java
   public class VarScopeDetail {
   	public static void main(String[] args) {
   		P p = new P();
   		p.t();
   	}
   }
   class P{
   	//1.属性和局部变量可以重名，访问时遵循就近原则。
   	String name = "as";
   	public void t(){
   		String name = "ab";
   		System.out.println("t方法中的name="+name);     //就近原则 ab
   		System.out.println("P类里面的name="+this.name);  //as  this 表示该类的对象相当于p.name
   	}
   	//在同一个作用域中，比如在同一个成员方法中，两个局部变量，不能重名。
   	public void h(){
   		Sring b = "avc";
   	//	Sring b = "assd";  错误重复定义；
   	}
   }
   ```

   

#### 6.7 构造器

##### 6.7.1 基本认识

1. 基本介绍

   构造方法又叫构造器，是类的一种特殊的方法，它的主要作用是完成对新对象的**属性初始化**，注意：不是创建对象调用的时候对象已经存在

2. 基本语法:

   [修饰符]   方法名(形参列表){

   ​		方法体;

   }

3. 事项说明:

   - 构造器也叫构造方法
   - 构造器**没有返回值**
   - 构造器的修饰符可以默认
   - **方法名和类名必须一致**
   - 构造器的调用由系统完成完成对象的属性初始化

##### 6.7.2 快速入门

1. 案例：在创建人类的对象时，就直接指定这个对象的年龄和姓名。

   ```java
   class Preson{
       //构造器
       public Preson(String name,int age){
           this.name = name;
           this.age = age;
       }
       String name;
       int age;
   }
   ```

##### 6.7.3 使用细节

1. 一个类可以定义多个不同的构造器，即构造器重载。
2. 构造器名和类名必须相同。
3. 构造器没有返回值不能写返回类型。
4. 构造器是完成对象属性的初始化，并不是创建对象。
5. 在创建对象时，系统自动的调用该类的构造方法。
6. 在没有定义构造器时会默认存在无参构造器可以默认初始化属性。
7. 一但自己定义构造器则默认无参构造器被覆盖而失效，如：Person();自己定义不能这样写要加{}

#### 6.8 this关键字的使用

##### 6.8.1 对象创建流程分析

1. 案例

   ```java
   class Person{
   	int age = 90;
   	String name;
   	Person(String n, int a){
   		name = n;
   		age = a;
   	}
   }
   Person p =new Person("ts",20); //分析这句话jvm的动作
   ```

   <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221016134900566.png" alt="image-20221016134900566" style="zoom:80%;" />

2. 流程分析：

   - 加载（Person）类信息，只会加载一次，
   - 创建对象开辟堆空间，对属性默认初始化
   - 显式初始化（初始赋值）初始化值
   - 系统自动调用构造器对属性初始化
   - p指向堆空间对象地址，对象的引用

##### 6.8.2 this关键字入门

1. 什么是this

   - java虚拟机会给每个对象分配this，代表当前对象。

2. 如何理解this

   ```java
   class Dog{
       public String name;
       Public int age;
       Public Dog(String name, int age){
           this.name = name;
           this.age = age;
       }   
   }
   //dog1.hashCode() = this.hashCode();
   ```

   ![image-20221016141837163](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221016141837163.png)

##### 6.8.3 this 总结

1. 哪个对象调用，this就代表哪个对象

##### 6.8.4 this 使用细节

1. this关键字可以用来访问本类的属性、方法、构造器。
2. this用于区分当前类的属性和局部变量。
3. 访问成员方法的语法：this.方法名(参数列表);  f();与this.f();有区别
4. 访问构造器语法：this(参数列表)；**注意只能在构造器中使用（即只能在构造器中访问另一个构造器且必须放在第一条语句）**。
5. this不能在类定义外部使用，只能在类定义的方法中使用。

##### 6.8.5 this练习

1. 案例：定义一个Person类，里面有name，age属性，并提供compareTo比较方法，用于判断是否和另一个人相等，提供测试类TestPerson用于测试，名字和年龄完全一样，就返回true否则返回false。

   ```java
   public class TestPerson {
   	public static void main(String[] args) {
   		Preson p1 = new Preson("ts",18);
   		Preson p2 = new Preson("ty",18);
   		System.out.println(p2.compareTo(p1)); 
   	}
   }
   /*
   定义一个Person类，里面有name，age属性，
   并提供compareTo比较方法，用于判断是否和另一个人相等，
   提供测试类TestPerson用于测试，
   名字和年龄完全一样，就返回true否则返回false。
    */
   class Preson{
   	String name;
   	int age;
   	public Preson(String name,int age){
   		this.name = name;
   		this.age = age;
   	}
   	public Preson(){}
   
   	public boolean compareTo(Preson p){
   		// if(this.name.equals(p.name) && this.age == p.age){
   		// 	return true;
   		// } else {
   		// 	return false;
   		// }
   		return (this.name.equals(p.name) && this.age == p.age);
   	}
   }
   ```

##### 6.8.6 本章练习题

1. 编写类A01，定义方法max，实现求某个double数组的最大值，并返回。

   ```java
   class A01{
   	public double max(double[] d ){
   		double max = d[0];
   		for (int i = 0;i < d.length-1 ;i++ ) {
   			if(d[i] < d[i+1] ){
   				max = d[i+1];
   			}
   		}
   		return max;
   	}
   }
   ```

   

2. 编写类A02，定义方法find，实现查找某字符串数组中的元素查找，并返回索引，如果找不到，返回-1。

   ```java
   class A02{
   	public int find(String[] s,String st){
   		int index = -1;
   		for (int i = 0;i < s.length ;i++ ) {
   			if(s[i].equals(st)){
   				index = i;
   			}
   		}
   		return index;
   	}
   }
   ```

   

3. 编写类Book，定义方法updatePrice，实现更改某本书的价格，具体:如果价格>150,则更改为150，如果价格>100,更改为100，否则不变。

   ```java
   class Book{
   	public void updatePrice(double money){
   		if(money > 150){
   			money = 150;
   			System.out.println("当前价格为："+money);
   		} else if(money > 100) {
   			money = 100;
   			System.out.println("当前价格为："+money);
   		} else {
   			System.out.println("当前价格为："+money);
   		}
   	}
   }
   ```

   

4. 编写类AO3，实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样。

   ```java
   class A03{
   	public int[] copyArr(int[] arr){
   		int[] arr1 = new int[arr.length];
   		for (int i = 0;i < arr.length ;i++ ) {
   			arr1[i] = arr[i];
   		}
   		return arr1;
   	}
   }
   ```

   

5. 定义一个圆类Circle,定义属性:半径，提供显示圆周长功能的方法，提供显示圆面积的方法。

   ```java
   class Circle{
   	double r;
   	final double pi = 3.14;
   	public Circle(double r){
   		this.r = r;
   	}
   	public void perimeter(){
   		double C = 0;
   		C = pi * this.r * 2;
   		System.out.println("该圆周长为：" + C);
   	}
   	public void area(){
   		double S = 0;
   		S = pi * this.r *this.r;
   		System.out.println("该圆面积为：" + S);
   	}
   }
   ```

   

6. 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试。

   ```java
   class Cale{
   	public void add(double a, double b){
   		double resul = 0;
   		resul = a + b;
   		System.out.println(a+"+"+b+"="+resul);
   	}
   	public void down(double a, double b){
   		double resul = 0;
   		resul = a - b;
   		System.out.println(a+"-"+b+"="+resul);
   	}
   	public void ride(double a, double b){
   		double resul = 0;
   		resul = a * b;
   		System.out.println(a+"*"+b+"="+resul);
   	}
   	public void except(double a, double b){
   		double resul = 0;
   		resul = a / b;
   		System.out.println(a+"/"+b+"="+resul);
   	}
   }
   
   ```

   

7. 设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。并创建对象，进行测试、【提示this.属性】。

   ```java
   class Dog{
   	String name;
   	String color;
   	int age;
   	public Dog(String name,String color	,int age){
   		this.name = name;
   		this.color = color;
   		this.age = age;
   	}
   	public void show(){
   		System.out.println("姓名："+this.name);
   		System.out.println("颜色："+this.color);
   		System.out.println("年龄："+this.age);
   	}
   }
   ```

   

8. 定义Music类，里面有音乐名name、音乐时长times属性，并有播放play功能和返回本身属性信息的功能方法。

   ```java
   class Music{
   	String name;
   	int times;
   	public Music(String name,int times){
   		this.name = name;
   		this.times = times;
   	}
   	public void show(){
   		System.out.println("音乐名:"+this.name);
   		System.out.println("音乐时长:"+this.times);
   	}
   	public void play(){
   		System.out.println("正在播放："+this.name);
   	}
   }
   ```

   

9. 在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，调用语句为:System.out.println(method(method(10.0,20.0),100);

   ```java
   class Te{
   	public double method(double m,double n){
   		return m + n;
   	}
   }
   ```

   

10. 创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造方法，可以初始化(1)(名字，性别，年龄),(2)(名字，性别，年龄，职位)(3)(名字，性别，年龄，职位，薪水)，要求充分复用构造器。

    ```java
    class Employee{
    	String name;
    	String sex;
    	int age;
    	String position;
    	double salary;
    	public Employee(String name,String sex,int age){
    		this.name = name;
    		this.sex =sex;
    		this.age = age;
    		System.out.println("三个被调用！！");
    	}
    
    	public Employee(String name,String sex,int age,String position){
    		this(name,sex,age);
    		this.position = position;
    		System.out.println("四个被调用！！");
    
    	}
    	public Employee(String name,String sex,int age,String position,double salary){
    		this(name,sex,age,position);
    		this.position = position;
    		this.salary = salary;
    	}
    
    }
    ```

    

11. 有个人 Tom设计他的成员变量.成员方法,可以电脑猜拳.电脑每次都会随机生成0,1,2；0表示石头1表示剪刀2表示布并要可以显示Tom的输赢次数(清单)。

    ```java
    class Tom{
    	public void fingerGuess(int x){
    		Random r = new Random();
    		int y = r.nextInt(3);
    		if(y == x){
    			System.out.println("平局");
    		}else if(x == 0 ){
    			if(y == 1){
    				System.out.println("你赢了");
    			}else{
    				System.out.println("你输了");
    			}				
    			
    		}else if(x == 1){
    			if(y == 2){
    				System.out.println("你赢了");
    			}else{
    				System.out.println("你输了");				
    			}
    		}else{
    			if(y == 0){
    				System.out.println("你赢了");
    			}else{
    				System.out.println("你输了");				
    			}
    		}
    	}
    }
    ```
    
    

### 7 面向对象重点

####  7.1 包与访问修饰符

##### 7.1.1 包的介绍与使用

1. 包的三大作用

   - 区分相同名字的类
   - 当类很多时，可以很好的管理类
   - 控制访问范围

2. 包基本语法

   package com.ts;

   说明：

   - package 关键字，表示打包。
   - com.ts:表示包名。

3. 包的本质

   用文件夹来管理源文件

4. 包的命名规则

   只能包含数字、字母、下划线、小圆点，但**不能用数字开头**，不能是Java关键字或者保留字。

5. 包的命名规范

   一般是:小写字母+点+......

   com.公司名.项目名.业务模块名

6. java常用系统包

   - java.lang.*     ---->lang包是基本包，默认引入，不需要再次引入。
   - java.util.*      ---->util包，系统提供的工具包，工具类。
   - java.net.*      ----->网络包，网络开发。
   - java.awt.*      ----->是做java的界面开发，GUI

7. 如何引入包

   1. 法一（建议使用）：
      - 语法：import   包 . 类;
      - 比如：import java.util.Scanner;  导入java.util包下的Scanner类。 
   2. 法二：
      - 语法：import  包 . *;
      - 比如：import java.util.Scanner;  导入java.util包下的所有类。 

8. 包使用细节

   - package的作用是声明当前类所在的包，需要放在类的最上面第一行，一个类最多只能有一句package。
   - import指令，放在package的下面，在主类定义的前面，可以有多条没有顺序要求。

##### 7.1.2 访问修饰符

- 基本介绍
  1. java提供四种访问控制修饰符号，用于控制方法和属性（成员变量）的访问权限（范围）：
     - 公开级别：用public修饰，对外公开
     - 受保护级别：用protected修饰，对子类和同一个包中的类公开
     - 默认级别：不写修饰符或者是default，向同一个包的类公开
     - 私有级别：用private修饰，只有类本身可以访问，不对外公开
  2. ![image-20221019144838056](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221019144838056.png)
- 使用细节
  1. 修饰符可以用来修饰类中的属性，成员方法以及类
  2. 类只能被public、默认修饰符修饰

#### 7.2 封装(encapsulation)

##### 7.2.1 什么是封装以及实现方法

1. 介绍

   封装（encapsulation）就是把抽象出来的数据【属性】和数据的操作【方法】封装在一起，数据被保护在内部，程序的其他部分只能通过被授权的操作【方法】，才能对数据进行操作。

2. 封装的优点

   - 可以对数据进行验证，保证安全合理，提高代码安全性
   - 提高代码复用性
   - 高内聚：隐藏功能实现细节，便于修改内部代码，提高可维护性
   - 低耦合：简化外部调用，便于调用者使用，便于扩展和协作

3. 封装实现步骤(三步)

   1. 将属性私有化private

   2. 提供一个公共的（public）set 方法，用于对属性判断并赋值

      ```java
      public void setAaa(类型 参数名){ //Aaa表示某个属性
          //加入数据的业务逻辑
          this.属性 = 参数名;
      }
      ```

   3. 提供一个公共的（public）get 方法,用于获取属性的值。

      ```java
      public 数据类型 getAaa(){ //Aaa表示某个属性，数据类型为该属性的数据类型
          return aaa;
      }
      ```

##### 7.2.2 封装快速入门

1. 入门案例
   有一个小程序(Encapsulation01.java),不能随便查看人的年龄（age）,工资(salary)等隐私，并对设置的年龄进行合理的验证。年龄合理就设置,否则给默认年龄,必须在1-120,年龄，工资不能直接查看，name的长度在2-6之间.

   ```java
   package com.ts.encap;
   /*
   有一个小程序(Encapsulation01.java),不能随便查看人的年龄（age）,
   工资(salary)等隐私，并对设置的年龄进行合理的验证。
   年龄合理就设置,否则给默认年龄,必须在1-120,年龄，工资不能直接查看，
   name的长度在2-6之间.
    */
   public class Encapsulation01 {
       public static void main(String[] args) {
           Wrokers wr = new Wrokers();
           wr.setName("abcef");
           System.out.println(wr.getName());
   
       }
   }
   class Wrokers{
       private String name;
       private int age;
       private String job;
       private double salary;
   
       public void setName(String name) {
           if (name.length() >= 2 && name.length() <= 6 ){
               this.name = name;
           }else {
               System.out.println("请输入正确的姓名！！！");
           }
       }
   
       public void setAge(int age) {
           if (age >= 18 && age <= 120){
               this.age = age;
           }else {
               System.out.println("请输入正确的年龄！！！");
           }
       }
   
       public void setJob(String job) {
           this.job = job;
       }
   
       public void setSalary(double salary) {
           this.salary = salary;
       }
   
       public int getAge() {
           return age;
       }
   
       public String getName() {
           return name;
       }
   
       public String getJob() {
           return job;
       }
   
   }
   ```

   

2. 使用技巧：

   如果有带参构造器，用户通过构造器设值的话就绕过了set方法控制，这样的话我们一般在构造器里面**调用**set方法。就解决了该问题。

   ```java
   public Wrokers(String name, int age, double salary) {
       this.setName(name);   //在构造器里调用set方法来进行设值
       this.setAge(age);    
       this.setSalary(salary);  //this可以省略
   }
   ```

3. 练习：

   创建程序，在其中定义两个类Account和AccountTest类

   1.Account类要求有属性：姓名（长度为2到4位）、余额（必须大于20）、密码（必须为6位），如果不满足给提示信息设置默认值

   2.通过set方法给Account的属性赋值

   3.在AccountTest中测试

   ```java
   package com.ts.encap;
   /*
   1.Account类要求有属性：姓名（长度为2到4位）、余额（必须大于20）、
   密码（必须为6位），如果不满足给提示信息设置默认值
   2.通过set方法给Account的属性赋值
   3.在AccountTest中测试
    */
   public class Account {
       private String name;
       private String pwd;
       private double surplus;
   
       public Account(String name, String pwd, double surplus) {
           this.setName(name);
           this.setPwd(pwd);
           this.setSurplus(surplus);
       }
   
       public void setName(String name) {
           if(name.length() >= 2 && name.length() <= 4){
               this.name = name;
           }else {
               System.out.println("你输入的用户名不合法给默认为“aaa”！！！");
               this.name = "aaa";
           }
       }
   
       public void setPwd(String pwd) {
           if (pwd.length() == 6){
               this.pwd = pwd;
           }else {
               System.out.println("你输入的密码不合法给默认为“aaa123”！！！");
               this.pwd = "aaa123";
           }
   
       }
   
       public void setSurplus(double surplus) {
           if (surplus >= 20){
               this.surplus = surplus;
           }else{
               System.out.println("余额不低于20给默认为“20”！！！");
               this.surplus = 20.0;
           }
       }
   
       public String getName() {
           return name;
       }
   
       public String getPwd() {
           return pwd;
       }
   
       public double getSurplus() {
           return surplus;
       }
       public void info(){
           System.out.println("姓名："+this.getName());
           System.out.println("密码："+this.getPwd());
           System.out.println("余额："+this.getSurplus());
       }
   
   }
   class AccountTest{
       public static void main(String[] args) {
           Account abc = new Account("abc", "123456", 12893);
           abc.info();
   
       }
   }
   
   
   ```

##### 7.2.3  封装的使用细节

1. 使用private访问权限
2. 对外提供public的get与set方法来访问相关属性
3. 对于数据类型为boolean的变量的get方法是is开头，如public isA(){} 

#### 7.3 继承（extends）

##### 7.3.1 为什么需要继承

1. 看一个问题

   编写两个类，一个是Pupil（小学生），一个是Graduate（研究生）。他们两个有很多相同的属性和方法，如果重复定义不合理也增加了工作量。有没有什么办法解决。---->继承

2. 代码

   ```java
   package com.ts.extend;
   //父类
   public class Student {
       String name;
       int age;
       String grade;
       private double score;
       public void setScore(double score) {
           this.score = score;
       }
   
       public double getScore() {
           return score;
       }
       public void testing(){
           System.out.println("学生"+this.name+"正在考试！！");
       }
       public void showInfo(){
           System.out.println("==========学生信息如下=========");
           System.out.println("学生姓名："+this.name);
           System.out.println("学生年龄："+this.age+"岁");
           System.out.println("就读年级："+this.grade);
           System.out.println("学生成绩："+this.getScore());
       }
   }
   
   ```

   ```java
   package com.ts.extend;
   
   public class Graduate extends Student{
       private int sid;
   
       public void setSid(int sid) {
           this.sid = sid;
       }
   
       public int getSid() {
           return sid;
       }
       public void  idIs(){
           System.out.println("学生id为："+this.getSid());
       }
   
   }
   
   ```

   ```java
   package com.ts.extend;
   
   public class Pupil extends Student {
       private int workTime;
   
       public void setWorkTime(int workTime) {
           this.workTime = workTime;
       }
   
       public int getWorkTime() {
           return workTime;
       }
   
       public void workTimes(){
           System.out.println("家庭作业时间为："+this.getWorkTime()+"分钟");
       }
   }
   
   ```

   

##### 7.3.2 继承入门

1. 基本介绍

   继承可以解决代码复用，当多个类存在相同的属性（变量）和方法时，可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法，所有的子类不需要重新定义这些属性和方法，只需要通过extends来声明继承父类

2. 继承基本语法

   class 子类 extends 父类{}

   - 子类就会自动拥有父类定义的属性和方法
   - 父类又叫超类，基类
   - 子类又叫派生类

3. 继承好处

   - 提高了代码的**复用性**
   - 提高了代码的**扩展性和维护性**

##### 7.3.3 继承使用细节

1. 子类继承了父类所有属性和方法，非私有的属性和方法可以在子类直接访问，但是私有属性和方法不能在子类直接访问，要通过父类public方法。
2. 在创建子类对象时子类的构造器必须先调用父类的构造器，完成父类的初始化。**可以通过子类调用该类其他构造器来完成。如this(参数列表)**
3. 当创建对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，**子类里的构造器会默认存在super();语句，这句话意思就是调用父类无参构造器**如果父类没有提供无参构造器，则必须在子类的构造器中使用super去指定使用父类的哪个构造器完成对父类的初始化工作，否则编译不通过。如：super("ttt",38);
4. 如果希望指定去调用父类的某个构造器，则显式的调用一下：super（参数列表）;
5. super在构造器里使用的时候，必须放在子类构造器的第一行。
6. super() 和 this() 在构造器里使用的时候都只能放在构造器的第一行，因此这两个方法不能共存在一个构造器里。
7. Java所有类都是Object的子类，自己定义的类也默认继承Object类
8. 父类构造器调用不限于直接父类！就一直往上追溯直到Object类，然后从上至下一一初始化。（顶级父类，基类）。
9. 子类最多只能继承一个父类（直接继承），即java中是单继承机制。
10. 不能滥用继承，子类和父类之间必须满足 A is a B 的逻辑关系

##### 7.3.4 继承的本质（底层原理）

1. 案例

   分析子类继承父类，创建子类对象时，内存发生了什么？

   回答：子类创建对象后，建立了以下的查找关系。

   (1)首先看子类是否有该属性

   (2)如果子类有该属性，并且能够访问，则返回该属性信息

   (3)如果没有该属性或不能访问（会报错），则向上寻找，就看父类有没有（同理）

   (4)如果一找到该属性就不会往上找了，如果该属性为私有无法访问则立马报错。

   (5)如果还没有就继续往上一级寻找，直到Object类

   (6)如果还找不到，就报错。

   ```java
   package com.ts.extend;
   
   public class ExtendsTheory {
       public static void main(String[] args) {
           Son son = new Son();  //内存布局。
           System.out.println(son.name);  //大头儿子
           System.out.println(son.age);   //30
           //Father-->privat int age = 30; 照样报错 
           System.out.println(son.hobby); //旅游
           //(1)首先看子类是否有该属性
           //(2)如果子类有该属性，并且能够访问，则返回该属性信息
           //(3)如果没有该属性或不能访问（会报错），则向上寻找，就看父类有没有（同理）
           //(4)如果还没有就继续往上一级寻找，直到Object
           //(5)如果还找不到，就报错。
   
       }
   }
   class Grandpa{
       String name = "大头爷爷";
       int age = 72;
       String hobby = "旅游";
   
   }
   class Father extends Grandpa{
       String name = "大头爸爸";
       int age = 30;
   }
   class Son extends Father{
       String name = "大头儿子";
   }
   ```

   <img src="C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221021150336827.png" alt="image-20221021150336827" style="zoom:80%;" />

2. 练习思考

   ```java
   class A{
       A(){System.out.println("a");}
       A(String name){System.out.println("a name");}
   }
   class B{
       B(){this("abc");System.out.println("b");}
       B(String name){System.out.println("b name");}
   }
   //main 中 B b = new B();输出什么？
   //a
   //b name
   //b
   ```

   

#### 7.4 super的使用

##### 7.4.1 super 的介绍及语法

1. 基本介绍

   super代表父类的引用，用于访问父类的属性、方法、构造器。

2. 基本语法

   - 能访问父类的属性，但不能访问父类的private属性(调用)

     super.属性名;

   - 访问父类方法，但不能访问父类的private方法（调用）

     super.方法名(参数列表);

   - 访问父类的构造器

     super(参数列表);  必须放在**构造器**的第一行，也只能有一条。

##### 7.4.2 super 的使用细节

1. 调用父类构造器好处

   分工明确（**this、super**），父类属性由父类初始化，子类属性由子类初始化。

2. 当子类和父类的成员中有重名时，为了访问父类的成员，必须通过super（super只是说跳过子类寻找从它的上一级父类开始）（因为重名this会直接调用自己的方法调用不到父类的方法,遵循寻找原则）。**如果没有重名，使用super、this、直接访问是一样的效果。**

   ```java
   package com.ts.super_;
   
   public class Super01 {
       public static void main(String[] args) {
           Y y = new Y();
           y.z();
           y.show();
           //你好我是儿子y（）
           //你好我是父亲x（）
           //你好我是父亲x（）
           //我是父亲w（）
       }
   
   }
   
   class X{
       String name = "xx";
       int age = 10;
       String pwd = "xx123";
       public void x(){
           System.out.println("你好我是父亲x（）");
       }
       public void w(){
           System.out.println("我是父亲w（）");
       }
   }
   
   class Y extends X{
       String name = "yy";
       int agg = 12;
       String pw = "yy123";
       public void y(){
           System.out.println("你好我是儿子y（）");
       }
       public void w(){
           System.out.println("我是儿子w（）");
       }
       public void z(){
           this.y();   //this调用自己的y()
           x();        //直接调用父类x()
       }
       public void show(){
           this.x();     //this调用父类x()
           super.w();    //super调用的是父类的w()
           this.w();     //调用自己的w()
           w();          //调用自己的w()
       }
   }
   
   ```

   

3. super 与this 的比较

   ![](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221021152840773.png)

#### 7.5 方法重写/覆盖（override）

##### 7.5.1 方法重写介绍

1. 基本介绍

   方法重写（覆盖）就是子类的一个方法和父类的某个方法的名称、返回类型、参数一样，那么我们就叫这个子类的方法覆盖了（重写了）父类的那个方法。

2. 重写不能只理解为父子两个类的关系可以是整条继承线，只要满足以上条件，重写爷爷或者.......都可以。

##### 7.5.2 方法重写注意事项

1. 子类方法的**参数，方法名称**，要和父类方法的**参数、方法名称**完全一样。

2. 子类方法的**返回类型**和**声明异常类型**要与父类方法的返回类型及声明异常类型**相同**，或者是父类返回类型的子类。比如父类方法返回类型是Object，子类方法返回类型是String.

   **由于String本身就是Object的子类满足重写**

3. 子类方法不能**缩小**父类方法的**访问权限**

##### 7.5.3 方法重载与重写比较

![image-20221022133511900](C:\Users\86177\AppData\Roaming\Typora\typora-user-images\image-20221022133511900.png)

#### 7.6 多态（polymorphism）

##### 7.6.1 多态的介绍

1. 多态即多种状态，是指**方法或对象**具有多种形态。建立在封装和继承基础之上的
2. 多态的具体表现
   - 方法的多态：方法重写与重载
   - 对象的多态：父类引用（**编译类型**）指向子类对象（**运行类型**）
     1. 一个对象的编译类型和运行类型可以不一致
     2. 编译类型在定义对象时，就确定了不能改变
     3. 运行类型是可变的
     4. 编译类型看定义时候  =  的左边，运行类型看   =  的右边。

##### 7.6.2 多态的入门

1. 案例：编写程序实现主人（Master）对不同的宠物喂食

   宠物（Pet）：狗（Dog）、猫（Cat）、猪（pig）

   食物（Food）：骨头（Bone）、鱼（Fish）、米饭（Rice）

   ```java
   package com.ts.poly_;
   //宠物类
   public class Pet {
       private String name;
   
       public Pet(String name) {
           this.name = name;
       }
   
       public String getName() {
           return name;
       }
   }
   //狗类
   class Dog extends Pet{
       public Dog(String name) {
           super(name);
       }
   }
   //猫类
   class Cat extends Pet{
       public Cat(String name) {
           super(name);
       }
   }
   //猪类
   class Pig extends Pet{
       public Pig(String name) {
           super(name);
       }
   }
   ```

   ```java
   package com.ts.poly_;
   
   public class Food {
       private String name;
   
       public Food(String name) {
           this.name = name;
       }
   
       public String getName() {
           return name;
       }
   }
   //骨头类
   class Bone extends Food{
       public Bone(String name) {
           super(name);
       }
   }
   //鱼类
   class Fish extends Food{
       public Fish(String name) {
           super(name);
       }
   }
   //米饭类
   class Rice extends Food{
       public Rice(String name) {
           super(name);
       }
   }
   
   
   ```

   ```java
   package com.ts.poly_;
   
   public class Master {
       private String name;
   
       public Master(String name) {
           this.name = name;
       }
   
       public String getName() {
           return name;
       }
       public void feedig(Pet pet,Food food){
           System.out.println("主人"+this.name+"正在给他的宠物"+pet.getName()+"喂食"+food.getName()+"!!!");
       }
   }
   
   ```

   ```java
   package com.ts.poly_;
   
   public class TestPoly_ {
       public static void main(String[] args) {
           Pet pet = new Dog("大黄狗");
           Food food = new Bone("大腿骨");
           Master master = new Master("小兰");
           master.feedig(pet,food);
           System.out.println("========================");
           Pet pet1 = new Cat("小花猫");
           Food food1 = new Fish("小黄鱼");
           Master master1 = new Master("小帅");
           master1.feedig(pet1,food1);
       }
   }
   /*
   主人小兰正在给他的宠物大黄狗喂食大腿骨!!!
   ========================
   主人小帅正在给他的宠物小花猫喂食小黄鱼!!!
   */
   ```

   

##### 7.6.3 多态的使用细节（向上转型与向下转型）

1. 多态的前提：存在继承关系

2. 多态的向上转型（语法对比自动类型转换）

   - 本质：父类引用指向子类对象

   - 语法：父类类型     引用名   =   new   子类类型();

   - 特点：**编译看左边，运行看右边**。可以调用父类的所有成员（需要遵守访问权限），不能调用子类中**特有**成员（父类不存在的方法或属性）。需要用到向下转型。

     ```java
     public class Pet {
         private String name;
     
         public Pet(String name) {
             this.name = name;
         }
     
         public String getName() {
             return name;
         }
     }
     
     class Dog extends Pet{
         int age = 10;  //特有成员
         public Dog(String name) {
             super(name);
         }
     }
     Pet pet = new Dog("大黄狗");  //向上转型
     pet.age = 20; //报错，不能访问到子类的特殊属性
     (Dog)pet.age = 20; //向下转型
     ```

     

3. 向上转型的调用方法规则

   1. 可以调用编译阶段类型的类里的所有成员及其父类的所有成员（遵循访问权限）
   2. 但是可以调用子类的成员
   3. 最终运行效果看子类（运行类型）的具体实现，即在调用方法时，按照从子类（运行类型）开始查找方法。

4. 多态的向下转型（语法对比强制类型转换）

   - 语法：子类类型     引用名  =  （子类类型）父类引用
   - 只能强制转父类引用，不能强制转父类对象
   - 要求父类的引用必须指向的是当前目标类型的对象
   - 当向下转型后，可以调用子类类型中所有的成员

5. 属性没有重写之说，属性的值看编译类型。例如：

   ```java
   class A{
       int count = 20;
   }
   class B extends A{
       int count = 10;
   }
   A a = new B();
   System.out.println(a.count);  //20
   ```

   ```java
   Pet--->Pig--->NaiPig
   Pet pp = new NaiPig("aaa");
   Pig p2 = (Pig)pp;
   master1.feeding(p2,food1);
   //主人小帅正在给他的宠物aaa喂食小黄鱼!!!
   ```

6. instanceof 运算符

   1. instanceof是二元运算符，用于判断对象的运行类型是否为XX类型或者XX类型的子类。

      ```java
      public class AAA {
          public static void main(String[] args) {
              BBB b = new BBB();
              AAA a = new BBB();
              AAA aa = new AAA();
              System.out.println(b instanceof BBB);  //true
              System.out.println(b instanceof AAA);  //true 
              System.out.println(a instanceof AAA);  //true
              System.out.println(a instanceof BBB);  //true
              System.out.println(aa instanceof BBB); //false
          }
      }
      class BBB extends AAA{
      }
      ```

##### 7.6.4 java中的动态绑定机制

1. 当调用对象**方法**的时候，该方法会和该对象的内存地址（运行类型）绑定。

2. 当调用对象**属性**时，没有动态绑定机制，哪里声明就在哪里使用。

3. 如下例题：

   ```java
   package com.ts.poly_.dynamic_bind;
   
   public class DynamicBind {
       public static void main(String[] args) {
           A a = new B();
           //注释掉子类的这两个方法后
           System.out.println(a.sum());  //40-->30
           System.out.println(a.sum1()); //30-->20
       }
   }
   class A{
       public int i =10;
       public int sum(){
           return get1()+10;  //会调用子类的get1() -->动态绑定
       }
       public int sum1(){
           return i+10;   //10 + 10 = 20
       }
       public int get1(){
           return i;
       }
   }
   class B extends A{
       public int i =20;
   //    public int sum(){
   //        return i+20;
   //    }
   //    public int sum1(){
   //        return i+10;
   //    }
       public int get1(){
           return i;  //20+10 = 30
       }
   }
   ```

   

##### 7.6.5 多态数组

1. 数组定义类型为父类类型（编译类型），里面保存的实际元素可以是子类类型（运行类型）。

2. 应用实例（看代码）：

   ```java
   package com.ts.poly_.poly_array;
   //人类
   public class Person {
       private String name;  //姓名
       private int age;      //年龄
   	//构造器
       public Person(String name, int age) {
           this.name = name;
           this.age = age;
       }
   	
       public String getName() {
           return name;
       }
   
       public int getAge() {
           return age;
       }
   	//返回自己的信息方法
       public String say() {
           return "姓名:" + name + "\t年龄:" + age;
       }
   }
   //学生类继承人类
   class Student extends Person {
       private double score;    //特有属性成绩
   	//构造器
       public Student(String name, int age, double score) {
           super(name, age);     //调用父类构造器对父类属性进行初始化
           this.score = score;
       }
   
       public double getScore() {
           return score;
       }
   	//重写父类say()方法
       public String say(){
           return "学生："+super.say() + "\t成绩:"+score;
       }
   	//特有的方法
       public void studing(){
           System.out.println("学生"+getName()+"正在学习......");
       }
   }
   //老师类继承人类
   class Teacher extends Person{
       private double salary;      //特有属性工资
   	//构造器
       public Teacher(String name, int age, double salary) {
           super(name, age);
           this.salary = salary;
       }
   
       public double getSalary() {
           return salary;
       }
   	//重写父类方法
       public String say(){
           return "老师："+super.say() + "\t薪水:"+salary;
       }
   	//特有方法
       public void teaching(){
           System.out.println("老师"+getName()+"正在教学......");
       }
   }
   ```

   ```java
   package com.ts.poly_.poly_array;
   
   public class TestPolyArray {
       public static void main(String[] args) {
   //        Person p1 = new Teacher("小张",48,6000);
   //        System.out.println(p1.say());
           //创建五个对象分别如下，保存在一个Person类型数组中;
           Person[] ps = new Person[5];   //创建Person类型数组
           //给数组赋值
           ps[0] = new Person("ww",43);  
           ps[1] = new Student("tw",13,93);;
           ps[2] = new Student("wq",21,100);
           ps[3] = new Teacher("ta",34,10000);
           ps[4] = new Teacher("tin",53,20000);
           //打印输出每个对象都调用say()方法的结果：
           for (Person p:ps ) {
               System.out.println(p.say()); //动态绑定
           }
           System.out.println("--------------分界线-------------");
           //要求学生对象或者老师对象调用自己特有的方法：
           //1.利用instanceof运算符判断对象的运行类型是什么类型;
           //2.向下转型分别调用特有方法;
           for (int i = 0;i < ps.length;i++){
               if(ps[i] instanceof Student){     //判断运行类型对象为
                   ((Student) ps[i]).studing();  //向下转型再调用自己特有的方法
               } else if(ps[i] instanceof Teacher){
                   ((Teacher)ps[i]).teaching();
               } else {
                   System.out.println("你是普通人！！！");
               }
           }
       }
   }
   /*
   姓名:ww	年龄:43
   学生：姓名:tw	年龄:13	成绩:93.0
   学生：姓名:wq	年龄:21	成绩:100.0
   老师：姓名:ta	年龄:34	薪水:10000.0
   老师：姓名:tin	年龄:53	薪水:20000.0
   --------------分界线-------------
   你是普通人！！！
   学生tw正在学习......
   学生wq正在学习......
   老师ta正在教学......
   老师tin正在教学......
   
   Process finished with exit code 0
   
   */
   ```

##### 7.6.6 多态参数

1. 定义

   形参类型为父类类型，实参传输允许为子类类型。

2. 案例：

   （1）定义员工类Employee，包含姓名（name）和月工资（monthSalary）[private]，以及计算年工资getAnnual的方法。普通员工（Worker）和经理（Manager）继承了员工，经理类多了奖金bonus属性和管理manage方法，普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法
   （2）测试类中添加一个方法showEmpAnnual(Employee e)，实现获取任何员工对象的年工资,并在main方法中调用该方法[e.getAnnual0]
   （3）测试类中添加一个方法，testWork,如果是普通员工，则调用work方法，如果是经理,则调用manage方法

   ```java
   package com.ts.poly_.parameter;
   
   public class Employee {
       private String name;
       private double monthSalary;
   
       public Employee(String name, double monthSalary) {
           this.name = name;
           this.monthSalary = monthSalary;
       }
   
       public String getName() {
           return name;
       }
   
       public double getMonthSalary() {
           return monthSalary;
       }
   
       public double getAnnual(){
           return monthSalary*12;
       }
   }
   class Worker extends Employee{
       public Worker(String name, double monthSalary) {
           super(name, monthSalary);
       }
   
       public void work(){
           System.out.println("员工"+getName()+"正在工作...");
       }
   
       public double getAnnual(){
           return super.getAnnual();
       }
   }
   class Manager extends Employee{
       private double bonus;
   
       public Manager(String name, double monthSalary, double bonus) {
           super(name, monthSalary);
           this.bonus = bonus;
       }
   
       public void manage(){
           System.out.println("经理"+getName()+"正在管理工作...");
       }
   
       public double getAnnual(){
           return super.getAnnual()+bonus;
       }
   }
   
   ```

   ```java
   package com.ts.poly_.parameter;
   
   public class Test {
       public static void main(String[] args) {
           Employee er = new Manager("大堂经理", 10000, 1200);
           Employee ee = new Worker("小王", 8000);
           Test t = new Test();
           System.out.println("----------------测试一--------------");
           t.showEmpAnnual(er);
           t.showEmpAnnual(ee);
           System.out.println("----------------测试二--------------");
           t.testWork(er);
           t.testWork(ee);
           System.out.println("----------------测试完毕--------------");
       }
       public void showEmpAnnual(Employee ee){
           System.out.println(ee.getName()+"年工资为："+ee.getAnnual());
       }
   
       public void testWork(Employee ee){
           if (ee instanceof Worker){
               ((Worker) ee).work();
           } else if(ee instanceof Manager){
               ((Manager) ee).manage();
           } else {
               System.out.println("你的对象有误");
           }
       }
   }
   /*
   ----------------测试一--------------
   大堂经理年工资为：121200.0
   小王年工资为：96000.0
   ----------------测试二--------------
   经理大堂经理正在管理工作...
   员工小王正在工作...
   ----------------测试完毕--------------
   */
   ```

#### 7.7 java内部类（Object）

##### 7.7.1 Object类equals方法

1. package java.lang.Object

2. 类`Object`是类层次结构的根。 每个类都由`Object`作为超类。 所有对象（包括数组）都实现此类的方法。

3. equals方法：

   equals方法是Object类中的成员方法，只能判断引用类型，某个其他对象是否“等于”此对象（地址判断）。但是在它的子类当中往往重写了该方法，用于判断两个对象是否为同一对象或者两个对象的值是否相等。比如String类

   对比  == 的使用区别。

   1. == 是比较运算符

   2. == 用于基本数据类型比较时比的是数值是否相等。

   3. == 用于对象比较时，比的是地址（运行类型）是否相等。（即是否为同一对象）

   4. 案例：自己重写一个equals方法，判断两个Person对象的内容是否相等（属性值）name、age、gender

      ```java
      package com.ts.object;
      
      public class Person {
          private String name;
          private int age;
          private String gender;
      
          public Person(String name, int age, String gender) {
              this.name = name;
              this.age = age;
              this.gender = gender;
          }
      
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
          public int getAge() {
              return age;
          }
      
          public void setAge(int age) {
              this.age = age;
          }
      
          public String getGender() {
              return gender;
          }
      
          public void setGender(String gender) {
              this.gender = gender;
          }
          /*
          自己重写一个equals方法，判断两个Person对象的内容是否相等
          （属性值）name、age、gender
           */
          public boolean equals(Object obj){
              if(this == obj){    //判断当前对象与比较对象是否为同一对象
                  return true;
              }
              if(obj instanceof Person){   //判断当前对象是不是Person或者子类对象
                  Person p1 = (Person)obj; //向下转型
                  Person p2 = this;
                  //判断属性是否相等。
                  if (p1.getName() == p2.getName() && p1.getAge() == p2.getAge() && p1.getGender() == p2.getGender()){
                      return true;
                  }
                  return false;
                  //以上代码可简写为下面这一句
                  //return if(p1.name.equals(p2.name) && p1.gender ==p2.gender && p1.age == p2.age);
              }
              return false;
          }
      }
      
      ```

##### 7.7.2 hashCode方法

1. public int hashCode()：

   返回对象的哈希码值。 支持此方法的好处是哈希表，例如`HashMap`提供的哈希表

2. 作用规则：

   - 提高具有哈希结构的容器的效率！
   - 两个引用，如果指向的是同一对象，则哈希值肯定是一样的！
   - 两个引用，如果指向不同对象，则哈希值一般不一样！
   - 哈希值主要根据对象的地址号而来，不能完全将哈希值等价于地址 。

##### 7.7.3 toString方法

1. 介绍：

   默认返回：全类名（包+类）+@+哈希值的十六进制，子类往往重写该方法，用于返回对象的属性信息

2. 当直接输出一个对象时，toString方法会被默认的调用，比如System.out。println(monster);会自动调用monster.toString()

##### 7.7.4 finalize方法

1. 当对象被回收时，系统自动调用该对象的finalize方法。子类可以重写该方法，做一些**释放资源**的操作。
2. 什么时候能被回收：当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用finalize方法。
3. 垃圾回收机制的调用，是由系统来决定，也可以通过System.gc()主动触发垃圾回收机制。
### 8 面向对象编程（高级）

#### 8.1 类变量与类方法（static关键字）

##### 8.1.1 类变量

1. 含义：

   类变量又叫静态变量，用static关键字声明。同一个类所有对象共享，类变量的生命周期和类一样。

2. 语法定义：

   - 访问修饰符  static  数据类型   变量名;
   - static  访问修饰符   数据类型   变量名;

3. 如何访问类变量

   - 类名.类变量名

   - 对象名.类变量名

     类变量是随类的加载而创建，即使没有实例化对象也可以访问。

4. 类变量的使用细节

   - 什么时候需要类变量

     当某个类的变量需要被它的所有对象共享时，就可以考虑类变量，比如：定义学生类，统计所有学生公交了多少钱。

   - 类变量与实例变量（普通属性）的区别

     类变量是该类的所有对象共享的随类的加载而创建，而实例变量是每个对象独享的随对象的创建而被实例化。

   - 加上static称为类变量或者静态变量，否则为实例变量/普通变量/非静态变量。

##### 8.1.2 类方法

1. 类方法基本介绍

   类方法也叫静态方法。

2. 语法定义

   访问修饰符  static  返回类型  方法名(){}

    static  访问修饰符  返回类型  方法名(){}

3. 类方法的调用

   类名.类方法名()   或者  对象名.类方法名()

4. 类方法的使用场景

   - 当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法，提高开发效率。

     比如：工具类中的方法utils Math类、Arrays类、Collections集合类

   - 在实际开发中，往往会将一些通用的方法（造轮子）设计成静态方法，这样不需要创建对象就可以直接使用了。

5. 类方法使用细节

   - 类方法和普通方法都是随类的加载而加载，将结构信息存储在方法区；类方法中没有this的参数，普通方法中隐含this参数
   - 普通方法和对象有关，需要通过对象名调用，不能通过类名调用。
   - 静态方法只可以访问静态成员或者静态方法，普通成员方法，既可以访问普通变量（方法），也可以访问静态变量（方法）。
   - 类方法中不允许使用和对象有关的关键字。如this、super。

#### 8.2 main方法

1. public  static  void  main(String[] args){} ---->JVM调用。
   - java虚拟机（jvm）需要调用类的main()方法，所以该方法必须为public
   - java虚拟机（jvm）在执行main()方法时不必创建对象，所以该方法必须为static
   - 该方法接收String类型的数组参数，该数组中保存执行Java命令时传递给所运行的类的参数，接收参数。
   - cmd ==> java  执行的程序   参数1   参数2  ......
2. 在main()方法中，我们可以直接调用main()方法所在类的静态方法或静态属性。
3. 不能直接访问该类的非静态成员，必须创建实例对象才能通过对象去访问类中的非静态成员

#### 8.3 代码块

##### 8.3.1 基本介绍

1. 代码化块又称初始化块，属于类中的成员【类的一部分】，类似于方法，将逻辑语句封装在方法体中，通过{}包围起来。
2. 和方法不同，没有方法名，没有返回值，没有参数，只有方法体，而且不用通过对象或者类显式调用，而是**加载类时**，或者**创建对象时隐式调用**。

##### 8.3.2 基本语法

1. [修饰符]{

   代码

   };

2. 注意说明：

   - 修饰符可选，要写的话**只能写 static**
   - 代码块分为两类，使用static修饰的叫静态代码块，没有static修饰的叫普通代码块/非静态代码块
   - 逻辑语句可以为任何逻辑语句（输入输出，方法调用，循环，判断等）
   - 最后的  ;  可以省略。

##### 8.3.3 代码块的好处与应用

1. 好处

   - 相当于另一种形式的构造器（对构造器的补充机制）,可以做初始化的操作
   - 如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性

2. 应用

   - 案例1

     ```java
     package com.ts.codeblock;
     
     public class CodeBlock01 {
         public static void main(String[] args) {
             new Movie("zhangshan",120,"lisi");
         }
     }
     
     class Movie {
         private String name;
         private double price;
         private String director;
     
         public Movie(String name) {
             this.name = name;
             System.out.println("构造器public Movie(String name)被调用。。。");
         }
     
         public Movie(String name, double price) {
             //this.name = name;
             this(name);
             this.price = price;
             System.out.println("构造器public Movie(String name，double price)被调用。。。");
         }
     
         public Movie(String name, double price, String director) {
     //        this.name = name;
     //        this.price = price;
             this(name,price);
             this.director = director;
             System.out.println("构造器public Movie(String name, double price, String director)被调用。。。");
         }
         {
             System.out.println("你好");
             System.out.println("欢迎观看电影");
             System.out.println("电影结束了");
         }
     }
     
     
     /*
     你好
     欢迎观看电影
     电影结束了
     构造器public Movie(String name)被调用。。。
     构造器public Movie(String name，double price)被调用。。。
     构造器public Movie(String name, double price, String director)被调用。。。
     */
     ```

     说明：不管调用哪个构造器创建对象，都**先只调用一次**代码块，再调用构造器。

     代码块调用优先于构造器

##### 8.8.4 代码块的使用细节和注意事项

1. **static代码块**也叫静态代码块，作用就是对类进行初始化，而且**随着类的加载而执行**，并且**只会执行一次**，如果使**普通代码块**，每**创建一个对象**，**就执行一次**。

2. **类**是什么时候被**加载**的（只加载一次）

   - 创建对象实例时（new）

   - 创建子类对象实例时，先加载父类再加载子类。

   - 使用类的静态成员时（静态属性，静态方法）

     特别说明：

     1. 子类被加载时必先加载父类，在使用静态成员时也会先加载父类
     2. 只声明对象不会加载类。如：Person p1;

3. 非静态代码块，在创建对象实例时，会被隐式调用。创建一个对象就调用一次代码块，可以理解为构造器的补充。

4. 如果只是使用类的静态成员时，非静态代码块并不会执行。

5. 创建一个对象时，在**一个类**调用顺序是：（**重难点**）

   - 第一：调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，多个的时候按照定义顺序调用）
   - 第二：调用普通代码块和普通属性初始化（注意：普通代码块和普通属性初始化调用优先级一样，多个的时候按照定义顺序调用）
   - 第三：调用构造器

6. 构造器的最前面其实隐含了super()和调用普通代码块，静态相关的代码块，属性初始化，在类加载时，就执行完毕了，因此是优先于构造器和普通代码块的执行。

7. 创建一个子类对象时（继承关系，父类要追随到Object，子类指当前类），他们的静态代码块调用，静态属性初始化，普通代码块调用，普通属性初始化，构造器的调用顺序如下：

   - 第一：调用父类静态代码块和对父类静态属性初始化（优先级一样，有多个时看定义的先后顺序）
   - 第二：调用子类的静态代码块和对父类静态属性初始化（有多个时看定义的先后顺序）
   - 第三：调用父类的普通代码块以及父类普通属性的初始化
   - 第四：调用父类的构造器
   - 第五：调用子类的普通普通代码块以及父类普通属性的初始化
   - 第六：调用子类的构造器

8. 静态代码块只能直接调用静态成员，普通代码块可以调用任意成员。

#### 8.4 final关键字

##### 8.4.1 基本介绍

- final 可以修饰类、属性、方法和局部变量。
- 以下情况可以使用final关键字：
  1. 当不希望类被继承时，可以使用final修饰
  2. 当不希望父类的某个方法被子类覆盖\重写时，可以使用final修饰
  3. 当不希望类的某个属性的值被修改，可以使用final修饰
  4. 当不希望某个局部变量被修改，可以使用final修饰

##### 8.4.2 使用细节

1. final修饰的属性又叫常量，一般用XX_XX_XX来命名
2. final修饰的属性在定义时，必须赋初始值，并且以后不能再修改，赋值可以在如下位置之一：
   - 定义时：如 public  final  double  TAX_RATE  =  0.08;
   - 在构造器中
   - 在代码块中
3. 如果final修饰的属性是静态的，则初始化的位置只能是
   - 定义时
   - 在静态代码块，不能在构造器中赋值
4. final类不能被继承，但是可以实例化对象
5. 如果类不是final类，但是含有final方法，则该方法虽然不能被重写，但是可以被继承
6. 一般来说当一个类被修饰成final类时，它的成员方法没必要再修饰为final，画蛇添足。
7. final不能修饰构造器
8. final 和 static往往搭配使用，效率更高，不会导致类加载，底层编译器做了优化处理。
9. 包装类（integer，Double，Float，Boolean等），String类都是final类

#### 8.5 抽象类（abstract）

##### 8.5.1 抽象类的引出与定义

1. 引出
   - 父类方法的不确定性；比如：一个动物类里面有一个eat方法但是动物是抽象的不知道吃什么，具体由其子类来重写，如：猫吃鱼。这就导致了父类方法的不确定性。
   - 当父类的某些方法一定需要被声明，但又不确定需要实现什么功能时，我们可以将其声明为抽象方法，那么这个类也就是抽象类。
   - 抽象方法就是没有具体实现（方法体）的方法。
   - 当父类的一些方法不能确定时，可以用abstract关键字来修饰该方法，这个方法就是抽象方法，要求该类也必须用abstract来修饰。
2. 定义
   - 抽象类定义：  访问修饰符   abstract   类名{   }
   - 抽象方法定义：  访问修饰符  abstract   返回类型   方法名(参数列表);

##### 8.5.2 抽象类的使用细节

1. 抽象类不能被实例化 （new）
2. 抽象类可以没有抽象方法，还可以有实例方法
3. 一旦一个类里面包含抽象方法，则该类必须修饰为抽象类
4. abstract只能修饰类和方法
5. 抽象类还是一个类可以有任意成员，比如：非抽象方法，属性，构造器等
6. 抽象方法不允许有方法体
7. 抽象类被继承时，子类必须实现该类的所有抽象方法，除非子类也定义为抽象类。
8. 抽象方法不能使用private、final、和static来修饰与重写违背（不能被重写或者无关）。

#### 8.6 接口（interface）

##### 8.6.1 介绍和定义语法

- 基本介绍

  1. 接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，再根据具体情况把这些方法写出来。
  2. 在jdk8.0之前接口的所有方法都没有方法体。jdk8.0以及之后接口可以有静态方法，默认方法。

- 语法

  interface 接口名{

  //属性

  //方法

  }

  class  类名   implements   接口{

  必须实现接口的所有抽象方法。

  }

##### 8.6.2 接口的使用细节

1. 接口不能被实例化（new）

2. 接口中所有方法都是public方法，接口中抽象方法，可以不用abstract修饰（默认）。

3. 一个普通类实现接口，就必须将该接口的所有方法都实现

4. 抽象类实现接口，可以不用实现接口的方法

5. 一个类同时可以实现多个接口；如：class  T implements A,B{ }

6. 接口中的属性的修饰符必须为 public  static   final  。比如：int a = 1;实际上是 public  static   final  int  a = 1; (必须初始化)

7. 接口中的属性访问形式：接口名.属性名

8. 一个接口不能继承其他类，但是可以继承多个别的接口;

   比如：interface A extends  B,C{ }

9. 接口的修饰符只能是 public 和默认 ，和类的使用一样。

10. ```java
    interface A{
    	int a = 2;
    }
    class B implements A{
    	public static void main(String[] args){
    		B b = new B();
    		System.out.println(A.a);  //2
    		System.out.println(b.a);  //2
    		System.out.println(B.a);  //2
    	}
    }
    ```

##### 8.6.3 接口 VS 继承

1. 继承的价值主要在于：解决代码的复用性和可维护性
2. 接口的价值主要在于：设计好各种规范（方法），让其他类去实现这些方法。
3. 接口比继承更加灵活
4. 实现继承使用关键字extends 实现接口使用关键字implements
5. 接口在一定程度上实现了代码解耦

