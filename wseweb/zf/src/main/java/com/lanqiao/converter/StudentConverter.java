package com.lanqiao.converter;

import org.springframework.core.convert.converter.Converter;

import com.lanqiao.vo.Student;
/**
 * 例如，现在需要将form表单传来的字符串“1-张三-23”解析成学号为1、姓名为张三、年龄为23，
 * 并将这些值封装到一个学生对象之中，也就是说需要将字符串“1-张三-23”转换为Student对象类型。
 * ①创建自定义类型转换器
 * @author gg
 *
 */
public class StudentConverter 
implements Converter<String, Student>
{
 @Override
 public Student convert(String source)
 {
  //source值就是前端form传来的"1-张三-23"
  if (source != null)
  {
   //解析出source中的学号、姓名、年龄
   String[] vals = source.split("-");
   int stuNo = Integer.parseInt(vals[0]);
   String stuName = vals[1];
   int stuAge = Integer.parseInt(vals[2]);
           //将解析出的学号、姓名、年龄封装到Student对象之中
   Student student = new Student();
   student.setStuNo(stuNo); 
   student.setStuAge(stuAge);
   student.setStuName(stuName);
   return student;
  }
  return null;
 }
}