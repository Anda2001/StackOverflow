package com.stackoverflow.service;

import com.stackoverflow.entity.Tag;
import com.stackoverflow.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    //read tags
    public List<Tag> retrieveTags() {
        return (List<Tag>) tagRepository.findAll();
    }

    //create tag
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    //update tag
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    //delete tag
    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }
}
