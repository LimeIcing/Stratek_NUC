package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.CategoryModel;
import java.util.List;

/**
 * Interface that is implemented in CategoryRepository
 * Check CategoryRepository for method descriptions
 * @author ECS
 */
public interface CategoryRepositoryInterface {
    List<CategoryModel> get();
}
