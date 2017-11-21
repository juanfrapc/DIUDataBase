package diudatabase;

import javax.swing.DefaultListSelectionModel;

public class NoSelectionListModel extends DefaultListSelectionModel{

    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(-1, -1);
    }
    
}
