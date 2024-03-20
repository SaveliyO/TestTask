package model.entity.transaction;

import java.time.LocalDate;

public interface Transaction {

    void execute(int amount);
    void rollback();
}
