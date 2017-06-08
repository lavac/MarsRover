class Position {

    public enum Direction {
        East("E") {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? South : North;
            }
        },
        West("W") {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? North : South;
            }
        },
        South("S") {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? West : East;
            }

        },
        North("N") {
            @Override
            public Direction rotate(Direction.Rotation rotation) {
                return rotation == Direction.Rotation.R ? East : West;
            }

        };

        abstract Direction rotate(Direction.Rotation rotation);

        enum Rotation {
            R, L
        }

        String parameter;

        Direction(String parameter){
            this.parameter = parameter;
        }

        public static Direction fromString(String parameter){
            for(Direction direction : Direction.values()){
                if(parameter.equals(direction.parameter))
                    return direction;
            }
            return null;
        }
    }

}
