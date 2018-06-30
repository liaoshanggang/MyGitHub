package com.forward.spring.boot.blog;

import com.forward.spring.boot.blog.domain.es.EsBlog;
import com.forward.spring.boot.blog.repository.es.EsBlogRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchInActionApplicationTests {

	@Autowired
	private EsBlogRepository esBlogRepository;

	@Before
	public void initRepositoryData(){
		esBlogRepository.deleteAll();
		esBlogRepository.save(new EsBlog("登鹳雀楼","王之涣登鹳雀楼","白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
		esBlogRepository.save(new EsBlog("相思","王维相思","红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
		esBlogRepository.save(new EsBlog("静夜思","李白静夜思","床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
	}
	@Test
	public void testFindDistinctEsBlogByTitleContainingOrSummaryContaining() {
		String title="思";
		String summary="思";
		String content="思";
		Pageable pageable = new PageRequest(0,20);
		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContaining(title, summary, content, pageable);
		Assert.assertEquals(page.getTotalPages(),2);
		System.out.println("================2");
		for (EsBlog blog:page.getContent()){
			System.out.println(blog.toString());
		}
		System.out.println("================2");

        /*title="相思";
        page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContaining(title, summary, content, pageable);
        Assert.assertEquals(page.getTotalPages(),1);
        System.out.println("================1");
        for (EsBlog blog:page.getContent()){
            System.out.println(blog.toString());
        }
        System.out.println("================1");*/
	}

}
