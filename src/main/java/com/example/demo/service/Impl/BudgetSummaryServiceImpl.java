@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;
    private final UserRepository userRepository;

    public BudgetSummaryServiceImpl(
            BudgetPlanRepository budgetPlanRepository,
            TransactionLogRepository transactionLogRepository,
            UserRepository userRepository) {

        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BudgetSummaryResponse getSummary(Long userId, int month, int year) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BudgetPlan plan = budgetPlanRepository
                .findByUserAndMonthAndYear(user, month, year)
                .orElseThrow(() -> new RuntimeException("Budget plan not found"));

        double spent = transactionLogRepository
                .sumByUserAndMonthAndYear(user, month, year);

        double remaining = plan.getAmount() - spent;

        return new BudgetSummaryResponse(
                plan.getAmount(),
                spent,
                remaining
        );
    }
}
