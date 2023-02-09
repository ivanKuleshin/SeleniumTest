package pages;

public abstract class BasePopUp extends AbstractPage {
  protected static final String POPUP_IS_NOT_VISIBLE_MESSAGE =
      "'%s' popUp is NOT visible, but should be!";
  protected static final String POPUP_IS_VISIBLE_MESSAGE =
      "'%s' popUp is visible, but shouldn't be!";

  public BasePopUp() {
    super();
  }

  public abstract void waitUntilInvisible();

  public abstract void waitUntilVisible();
}
