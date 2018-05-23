package strateknuc.lasec.Models.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import strateknuc.lasec.Interfaces.CategoryRepositoryInterface;
import strateknuc.lasec.Models.CategoryModel;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements CategoryRepositoryInterface {

    // AUTHOR(S): ECS
    @Autowired
    private JdbcTemplate jdbc;

    // AUTHOR(S): ECS
    @Override
    public List<CategoryModel> get() {
        List<CategoryModel> categories = new ArrayList<>();
        String sql = "SELECT name FROM categories";
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            categories.add(new CategoryModel(rs.getString(1)));
        }

        return categories;
    }
}
