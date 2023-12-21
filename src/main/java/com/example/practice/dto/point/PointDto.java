package com.example.practice.dto.point;

import com.example.practice.entity.Point;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PointDto {

    private int holding;
    private int total;

    public Point toEntity() {
        Point point = new Point();
        point.setHolding(holding);
        point.setTotal(total);
        return point;
    }

    public static PointDto fromEntity(Point point) {
        return PointDto.builder()
                .holding(point.getHolding())
                .total(point.getTotal())
                .build();
    }
}
