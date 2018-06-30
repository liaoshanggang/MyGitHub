package com.forward.spring.boot.blog.repository.es;

import com.forward.spring.boot.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository  extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询去重
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContaining(String title, String summary,String content, Pageable pageable);
}
