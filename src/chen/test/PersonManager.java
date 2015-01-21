package chen.test;


import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.Session;

import chen.entity.*;
import chen.util.FormatDate;
import chen.util.HibernateUtil;

public class PersonManager {
	public static void main(String[] args) {
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}

	private void createAndStorePerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		BoardMaster bm = new BoardMaster();
		bm.setName("版主名字");// 1
		bm.setPass("版主密码");

		User u = new User();// 2
		u.setName("用户1");
		u.setPass("用户密码");

		Board bd = new Board();// 3
		bd.setName("版区名字");
		bd.setBm(bm);// 设置版区的版主

		Board ban = new Board();// 4
		ban.setName("版区二");
		ban.setBm(bm);// 设置版区的版主

		Role role = new Role("管理员");

		Administrator ad = new Administrator();// 5
		ad.setName("我是管理员");
		ad.setPass("管理员密码");

		MangerType type = new MangerType();// 6
		type.setName("超级管理员");// 管理员类型名字
		ad.setMangertype(type);;// 设置管理员类型

		session.save(new MangerType("前台管理员"));
		session.save(new MangerType("后台管理员"));
		session.save(role);

		Comment coment = new Comment();// 7
		coment.setContent("评论类容");
		coment.setUser(u);// 设置发表评论的用户

		Topic top = new Topic();// 8
		top.setView(10);
		top.setContent("帖子内容");
		top.setTitle("帖子标题");
		top.setU(u);// 设置所属用户
		top.setB(bd);// 设置版区
        top.setDate(new FormatDate());
		Topic topic = new Topic();// 9
		topic.setView(23);
		topic.setContent("帖子2内容");
		topic.setTitle("帖子2标题");
		topic.setU(u);// 设置所属用户
		topic.setB(bd);// 设置版区
		
		topic.setDate(new FormatDate());
		coment.setT(top);// 设置该评论属于哪个帖子

		Information info = new Information();
		info.setNickname("用户昵称");
		//info.getRegdate();
		info.setRegdate(new Date());
		u.setInfo(info);

		TopicState ts = new TopicState();// 10
		ts.setName("精华");

		top.setState(ts);// 设置帖子状态

		Authority au = new Authority(ban, top, 1, 0);// 11
		Authority auth = new Authority(ban, topic, 1, 0);// 12

		au.setU(u);
		auth.setU(ad);

		
		session.save(new Board("PE讨论区"));
		session.save(new Board("综合讨论区"));
		session.save(new Board("USB启动区"));
		
		session.save(new Board("杀毒软件"));
		session.save(new Board("数据恢复"));
		session.save(new Board("虚拟机"));
		
		session.save(new Board("灌水区"));
		session.save(new Board("版务公开区"));
		
		
		session.save(topic);
		session.save(ban);
		session.save(au);
		session.save(auth);
		session.save(coment);
		session.save(top);
		session.save(ad);
		session.save(type);
		session.save(bd);
		session.save(u);
		session.save(bm);
		session.save(ts);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
