package strateknuc.lasec.Interfaces;

import strateknuc.lasec.Models.CategoryModel;
import java.util.List;

/**
 * @author ECS
 * Interface that is implemented in CategoryRepository
 * Check CategoryRepository for method descriptions
 */
public interface CategoryRepositoryInterface {
    List<CategoryModel> get();
}
