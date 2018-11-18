import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class boardMouseListener implements MouseListener {
	
	private notificationsManager notesManager;
	
		
	public boardMouseListener(notificationsManager nManager)
	{
		notesManager = nManager;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int x = (int) (1 + e.getX() / 30);
		int y = (int) (1 + e.getY() / 30);

		try {
			actionManager.getInstance().executeAction(x, y);
		} catch (Exception ex) {
			notesManager.notifyError("Erro ao executar ação:\n" + ex.getMessage());
		}

	}
}
