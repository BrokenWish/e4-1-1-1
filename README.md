# zhihudemo

分别有两张表，user和comment

* user表是用户表，有6个属性，分别是：
  * id 主键
  * user_id 用户的唯一标识
  * phoneAndEmail 用户登录名
  * pwd 用户登录密码
  * gmt_created 用户创建时间
  * gmt_modified 用户修改密码的时间
  

* comment表是评论表，有7个属性
    * id 主键
    * user_id 关联用户的唯一标识，用于判断谁发送的评论
    * ref_id 评论的唯一标识
    * content 评论的内容
    * parent_id 父评论的id
    * gmt_created 评论创建时间
    * gmt_modified 评论被修改的时间
  

1.完成了注册与登录模块
    点击点赞，踩，右上角的登录以及查看评论均会触发登录时间

2.完成了首页开发
    大部分都设置了鼠标的效果，hover，foucs等

3.完成了帖子内容的展示
  点击展开全文，即可展示帖子的所有内容

4.完成了回到顶部功能
  点击右下角的上箭头，即可以丝滑的移动到页面顶部

评论功能因学校课程太多，每天四节课+课后实验，导致未完全制作完成。

------------------------------------------------------

代码仓库：https://github.com/BrokenWish/e4-1-1-1.git
