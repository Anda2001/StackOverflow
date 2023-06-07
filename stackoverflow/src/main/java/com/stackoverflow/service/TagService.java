package com.stackoverflow.service;

import com.stackoverflow.entity.QuestionTag;
import com.stackoverflow.entity.Tag;
import com.stackoverflow.repository.QuestionTagRepository;
import com.stackoverflow.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    @Autowired
    QuestionTagRepository questionTagRepository;

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

    //read tag by name
    public Tag retrieveTagByName(String name) {
        List<Tag> tags = retrieveTags();
        for (Tag tag : tags) {
            if (tag.getTitle().equals(name)) {
                return tag;
            }
        }
        return null;
    }

    public List<Tag> retrieveTagByQuestionId(int id) {
        List<Tag> tags = retrieveTags();
        List<QuestionTag> questionTags = (List<QuestionTag>) questionTagRepository.findAll();
        List<Long> tagIds = new ArrayList<>();
        List<Tag> questionTagsList = new ArrayList<>();

        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getQuestion().getQuestionId() == id) {
                tagIds.add(questionTag.getTag().getTagId());
            }
        }

        for (Tag tag : tags) {
            if (tagIds.contains(tag.getTagId())) {
                questionTagsList.add(tag);
            }
        }

        return questionTagsList;
    }

    public Tag retrieveTagById(Long tagId) {
        List<Tag> tags = retrieveTags();
        for (Tag tag : tags) {
            if (tag.getTagId().equals(tagId)) {
                return tag;
            }
        }
        return null;
    }
}
