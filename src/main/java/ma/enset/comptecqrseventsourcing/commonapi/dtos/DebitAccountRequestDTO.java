package ma.enset.comptecqrseventsourcing.commonapi.dtos;

import lombok.Data;

@Data
public class DebitAccountRequestDTO {
    private String accoundId;
    private double amount;
    private String currency;

}
