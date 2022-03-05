package services;

import models.Mark;

public interface MarkService {
    void createMark(Mark mark);
    Mark readMark(int id);
    void updateMark(Mark mark);
    void deleteMark(int id);
}
