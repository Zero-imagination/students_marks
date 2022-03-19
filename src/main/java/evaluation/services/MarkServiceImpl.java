package evaluation.services;

import evaluation.dao.MarkDaoImpl;
import evaluation.model.Mark;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MarkServiceImpl implements MarkService{
    private final MarkDaoImpl markDao;

    public MarkServiceImpl(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.markDao = new MarkDaoImpl(factory);
    }

    @Override
    public void createMark(Mark mark) {
        this.markDao.create(mark);
    }

    @Override
    public Mark readMark(int id) {
        return this.markDao.read(id);
    }

    @Override
    public void updateMark(Mark mark) {
        this.markDao.update(mark);
    }

    @Override
    public void deleteMark(int id) {
        this.markDao.delete(id);
    }
}
