package dao;

import models.Mark;

public interface MarkDao {
    void create(Mark mark);
    Mark read(int id);
    void update(Mark mark);
    void delete(int id);
}
