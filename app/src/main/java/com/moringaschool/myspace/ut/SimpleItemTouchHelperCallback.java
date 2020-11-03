package com.moringaschool.myspace.ut;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperAdapter mAdapter;

    //  The constructor takes ItemTouchHelperAdapter parameter, the ItemTouchHelperAdapter instance will pass the gesture event.

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter adapter) {
        mAdapter = adapter;
    }

    //  Informs the ItemTouchHelperAdapter that drag gestures are enabled.

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    //  Informs the ItemTouchHelperAdapter that swipe gestures are enabled.

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    //  MovementFlags informs the ItemTouchHelper which movement directions are supported.

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    //  notify the adapter that an item has moved.

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source,
                          RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        mAdapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    //  will tell the adapter that an item was released which activates onItemDismiss overide the firebase adapter.

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}