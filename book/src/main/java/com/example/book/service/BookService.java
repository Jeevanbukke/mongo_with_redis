package com.example.book.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;



import java.util.Objects;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;



import com.example.book.model.DatabaseSequence;



@Service


public class BookService {



   private static MongoOperations mongoOperations;



   public BookService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }



   public static long generateSequence(String seqName) {



       DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;



   }
}


