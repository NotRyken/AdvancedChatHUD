package io.github.darkkronicle.advancedchathud.config;

import fi.dy.masa.malilib.gui.interfaces.ISelectionListener;
import fi.dy.masa.malilib.gui.widgets.WidgetListBase;
import io.github.darkkronicle.advancedchathud.AdvancedChatHud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import net.minecraft.client.gui.screen.Screen;

public class WidgetListTabs extends WidgetListBase<ChatTab, WidgetTabEntry> {

    public WidgetListTabs(
        int x,
        int y,
        int width,
        int height,
        @Nullable ISelectionListener<ChatTab> selectionListener,
        Screen parent
    ) {
        super(x, y, width, height, selectionListener);
        this.browserEntryHeight = 22;
        this.setParent(parent);
    }

    @Override
    protected WidgetTabEntry createListEntryWidget(
        int x,
        int y,
        int listIndex,
        boolean isOdd,
        ChatTab entry
    ) {
        return new WidgetTabEntry(
            x,
            y,
            this.browserEntryWidth,
            this.getBrowserEntryHeightFor(entry),
            isOdd,
            entry,
            listIndex,
            this
        );
    }

    @Override
    protected Collection<ChatTab> getAllEntries() {
        ArrayList<ChatTab> tabs = new ArrayList<>(
            Collections.singleton(HudConfigStorage.MAIN_TAB)
        );
        tabs.addAll(HudConfigStorage.TABS);
        return tabs;
    }
}
