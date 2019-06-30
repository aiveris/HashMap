package lt.sdacademy.hashmap;

public class EitherOr<E, O> {
    private E either;
    private O or;

    private EitherOr(E either, O or) {
        this.either = either;
        this.or = or;
    }

    public static <E, O> EitherOr<E, O> either(E either) {
        if (either == null) {
            throw new RuntimeException("You should have provided a value for either");
        }

        return new EitherOr(either, null);
    }

    public static <E, O> EitherOr<E, O> or(O or) {
        if (or == null) {
            throw new RuntimeException("You should have provided a value for or");
        }

        return new EitherOr(null, or);
    }

    public boolean isEither() {
        return either != null;
    }

    public boolean isOr() {
        return or != null;
    }

    public E getEither() {
        return either;
    }

    public O getOr() {
        return or;
    }
}