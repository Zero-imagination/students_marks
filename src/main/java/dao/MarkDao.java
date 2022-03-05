package dao;

import models.Mark;

import java.util.List;

public interface MarkDao {
    void create(Mark mark);
    Mark read(int id);
    void update(Mark mark);
    void delete(int id);
}
