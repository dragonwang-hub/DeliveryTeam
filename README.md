# About Project
This is a basic java (jdk 11+) project with gradle 7 & junit 5.


## Part one: OOP & TEST
XX集团准备成立新的交付团队--TG，以完成某向软件开发任务
1.可以向TG团队assign 成员（member）和交付任务（story）。
2.成员分为BA，DEV和QA。assign的成员和角色没有数量限制。
3.BA的工作是为交付团队产生1～3个新的story，并且给所有空闲的DEV assign一张卡（不需要考虑分配机制和策略）；DEV的工作是实现被assign的story。QA的工作是测试（移除）2个完成的卡（无特定要求怎么选择2个卡）。
4.DEV在已分配story的情况下再次分配新的story时，会产生带宽不足异常。

## Part two: Lambda
1.交付团队提供getMembers方法，能够根据getMembers的入参lambda返回适当的成员list，如 	
1.1 能够筛选出所有BA/QA/DEV成员，在项目里可以使用的地方用getMembers方法进行替换
1.2 能够筛选出所有名字里包含“a”的成员列表
2.向交付团队增加成员时，如果团队有特定角色的数量限制规则，则应用规则进行判断，符合规则添加成员，超出特定阈值抛出MemberRoleExceedException，如 	
2.1 向团队添加BA规则，最多2人，向团队添加第3位BA时抛出异常
2.2 向团队添加QA规则，最多1人，向团队添加第2位QA时抛出异常
2.3 向团队添加DEV规则，最多3人，向团队添加第4位DEV时抛出异常
2.3 不向团队添加任何规则时，添加成员无限制
3.在代码里可以使用方法引用(::)的地方进行替换(单独commit)

## Part three: Stream
Requirement Clarification
X集团准备成立新的交付团队--天宫，以完成某向软件开发任务
BA的工作是为交付团队产生1～3个新的story，并且给所有空闲的DEV assign一张卡（不需要考虑分配机制和策略）；
QA的工作是测试（移除）2个完成的卡（无特定要求怎么选择2个卡）。
要求：
上述功能使用stream实现
尽可能多且合适的使用stream operations
在代码里可以使用方法引用(::)的地方进行替换


